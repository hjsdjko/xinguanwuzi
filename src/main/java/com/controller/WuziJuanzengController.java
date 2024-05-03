
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.WuziEntity;
import com.entity.WuziJuanzengEntity;
import com.entity.YonghuEntity;
import com.entity.view.WuziJuanzengView;
import com.service.*;
import com.utils.CommonUtil;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 物资捐赠
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuziJuanzeng")
public class WuziJuanzengController {
    private static final Logger logger = LoggerFactory.getLogger(WuziJuanzengController.class);

    private static final String TABLE_NAME = "wuziJuanzeng";

    @Autowired
    private WuziJuanzengService wuziJuanzengService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//疫情公告
    @Autowired
    private LiuyanService liuyanService;//留言反馈
    @Autowired
    private NewsService newsService;//疫情资讯
    @Autowired
    private WuziService wuziService;//物资
    @Autowired
    private WuziCollectionService wuziCollectionService;//物资收藏
    @Autowired
    private WuziFafangService wuziFafangService;//物资发放
    @Autowired
    private WuziLiuyanService wuziLiuyanService;//物资留言
    @Autowired
    private WuziRukuService wuziRukuService;//物资入库
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YuangongService yuangongService;//员工
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = wuziJuanzengService.queryPage(params);

        //字典表数据转换
        List<WuziJuanzengView> list =(List<WuziJuanzengView>)page.getList();
        for(WuziJuanzengView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuziJuanzengEntity wuziJuanzeng = wuziJuanzengService.selectById(id);
        if(wuziJuanzeng !=null){
            //entity转view
            WuziJuanzengView view = new WuziJuanzengView();
            BeanUtils.copyProperties( wuziJuanzeng , view );//把实体数据重构到view中
            //级联表 物资
            //级联表
            WuziEntity wuzi = wuziService.selectById(wuziJuanzeng.getWuziId());
            if(wuzi != null){
            BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWuziId(wuzi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wuziJuanzeng.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WuziJuanzengEntity wuziJuanzeng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuziJuanzeng:{}",this.getClass().getName(),wuziJuanzeng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wuziJuanzeng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WuziJuanzengEntity> queryWrapper = new EntityWrapper<WuziJuanzengEntity>()
            .eq("wuzi_id", wuziJuanzeng.getWuziId())
            .eq("yonghu_id", wuziJuanzeng.getYonghuId())
            .eq("wuzi_juanzeng_number", wuziJuanzeng.getWuziJuanzengNumber())
            .in("wuzi_juanzeng_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuziJuanzengEntity wuziJuanzengEntity = wuziJuanzengService.selectOne(queryWrapper);
        if(wuziJuanzengEntity==null){
            wuziJuanzeng.setInsertTime(new Date());
            wuziJuanzeng.setWuziJuanzengYesnoTypes(1);
            wuziJuanzeng.setCreateTime(new Date());
            wuziJuanzengService.insert(wuziJuanzeng);
            return R.ok();
        }else {
            if(wuziJuanzengEntity.getWuziJuanzengYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(wuziJuanzengEntity.getWuziJuanzengYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuziJuanzengEntity wuziJuanzeng, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wuziJuanzeng:{}",this.getClass().getName(),wuziJuanzeng.toString());
        WuziJuanzengEntity oldWuziJuanzengEntity = wuziJuanzengService.selectById(wuziJuanzeng.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wuziJuanzeng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wuziJuanzengService.updateById(wuziJuanzeng);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WuziJuanzengEntity wuziJuanzengEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,wuziJuanzengEntity:{}",this.getClass().getName(),wuziJuanzengEntity.toString());

        WuziJuanzengEntity oldWuziJuanzeng = wuziJuanzengService.selectById(wuziJuanzengEntity.getId());//查询原先数据

        if(wuziJuanzengEntity.getWuziJuanzengYesnoTypes() == 2){//通过

            WuziEntity wuziEntity = wuziService.selectById(oldWuziJuanzeng.getWuziId());
            if(wuziEntity == null)
                return R.error("查不到物资");
            int balance = wuziEntity.getWuziKucunNumber() + oldWuziJuanzeng.getWuziJuanzengNumber();
            wuziEntity.setWuziKucunNumber(balance);
            wuziService.updateById(wuziEntity);

        }else if(wuziJuanzengEntity.getWuziJuanzengYesnoTypes() == 3){//拒绝
        }
        wuziJuanzengEntity.setWuziJuanzengShenheTime(new Date());//回复时间
        wuziJuanzengService.updateById(wuziJuanzengEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WuziJuanzengEntity> oldWuziJuanzengList =wuziJuanzengService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wuziJuanzengService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<WuziJuanzengEntity> wuziJuanzengList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WuziJuanzengEntity wuziJuanzengEntity = new WuziJuanzengEntity();
//                            wuziJuanzengEntity.setWuziJuanzengUuidNumber(data.get(0));                    //捐赠编号 要改的
//                            wuziJuanzengEntity.setWuziId(Integer.valueOf(data.get(0)));   //物资 要改的
//                            wuziJuanzengEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wuziJuanzengEntity.setWuziJuanzengText(data.get(0));                    //捐赠缘由 要改的
//                            wuziJuanzengEntity.setWuziJuanzengNumber(Integer.valueOf(data.get(0)));   //捐赠数量 要改的
//                            wuziJuanzengEntity.setInsertTime(date);//时间
//                            wuziJuanzengEntity.setWuziJuanzengYesnoTypes(Integer.valueOf(data.get(0)));   //捐赠状态 要改的
//                            wuziJuanzengEntity.setWuziJuanzengYesnoText(data.get(0));                    //捐赠回复 要改的
//                            wuziJuanzengEntity.setWuziJuanzengShenheTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            wuziJuanzengEntity.setCreateTime(date);//时间
                            wuziJuanzengList.add(wuziJuanzengEntity);


                            //把要查询是否重复的字段放入map中
                                //捐赠编号
                                if(seachFields.containsKey("wuziJuanzengUuidNumber")){
                                    List<String> wuziJuanzengUuidNumber = seachFields.get("wuziJuanzengUuidNumber");
                                    wuziJuanzengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wuziJuanzengUuidNumber = new ArrayList<>();
                                    wuziJuanzengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wuziJuanzengUuidNumber",wuziJuanzengUuidNumber);
                                }
                        }

                        //查询是否重复
                         //捐赠编号
                        List<WuziJuanzengEntity> wuziJuanzengEntities_wuziJuanzengUuidNumber = wuziJuanzengService.selectList(new EntityWrapper<WuziJuanzengEntity>().in("wuzi_juanzeng_uuid_number", seachFields.get("wuziJuanzengUuidNumber")));
                        if(wuziJuanzengEntities_wuziJuanzengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuziJuanzengEntity s:wuziJuanzengEntities_wuziJuanzengUuidNumber){
                                repeatFields.add(s.getWuziJuanzengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [捐赠编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wuziJuanzengService.insertBatch(wuziJuanzengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wuziJuanzengService.queryPage(params);

        //字典表数据转换
        List<WuziJuanzengView> list =(List<WuziJuanzengView>)page.getList();
        for(WuziJuanzengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuziJuanzengEntity wuziJuanzeng = wuziJuanzengService.selectById(id);
            if(wuziJuanzeng !=null){


                //entity转view
                WuziJuanzengView view = new WuziJuanzengView();
                BeanUtils.copyProperties( wuziJuanzeng , view );//把实体数据重构到view中

                //级联表
                    WuziEntity wuzi = wuziService.selectById(wuziJuanzeng.getWuziId());
                if(wuzi != null){
                    BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWuziId(wuzi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(wuziJuanzeng.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WuziJuanzengEntity wuziJuanzeng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wuziJuanzeng:{}",this.getClass().getName(),wuziJuanzeng.toString());

            wuziJuanzeng.setInsertTime(new Date());
            wuziJuanzeng.setWuziJuanzengYesnoTypes(1);
            wuziJuanzeng.setCreateTime(new Date());
            wuziJuanzengService.insert(wuziJuanzeng);

            return R.ok();

    }

}

