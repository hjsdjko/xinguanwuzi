
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.WuziEntity;
import com.entity.WuziFafangEntity;
import com.entity.YuangongEntity;
import com.entity.view.WuziFafangView;
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
 * 物资发放
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuziFafang")
public class WuziFafangController {
    private static final Logger logger = LoggerFactory.getLogger(WuziFafangController.class);

    private static final String TABLE_NAME = "wuziFafang";

    @Autowired
    private WuziFafangService wuziFafangService;


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
    private WuziJuanzengService wuziJuanzengService;//物资捐赠
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
        PageUtils page = wuziFafangService.queryPage(params);

        //字典表数据转换
        List<WuziFafangView> list =(List<WuziFafangView>)page.getList();
        for(WuziFafangView c:list){
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
        WuziFafangEntity wuziFafang = wuziFafangService.selectById(id);
        if(wuziFafang !=null){
            //entity转view
            WuziFafangView view = new WuziFafangView();
            BeanUtils.copyProperties( wuziFafang , view );//把实体数据重构到view中
            //级联表 员工
            //级联表
            YuangongEntity yuangong = yuangongService.selectById(wuziFafang.getYuangongId());
            if(yuangong != null){
            BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYuangongId(yuangong.getId());
            }
            //级联表 物资
            //级联表
            WuziEntity wuzi = wuziService.selectById(wuziFafang.getWuziId());
            if(wuzi != null){
            BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWuziId(wuzi.getId());
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
    public R save(@RequestBody WuziFafangEntity wuziFafang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuziFafang:{}",this.getClass().getName(),wuziFafang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            wuziFafang.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        WuziEntity wuziEntity = wuziService.selectById(wuziFafang.getWuziId());
        if(wuziEntity == null)
            return R.error("查不到物资");
        int balance = wuziEntity.getWuziKucunNumber() - wuziFafang.getWuziFafangNumber();
        if(balance<0){
            return R.error("发放物资不能大于库存物资");
        }
        wuziEntity.setWuziKucunNumber(balance);
        wuziService.updateById(wuziEntity);


            wuziFafang.setInsertTime(new Date());
            wuziFafang.setCreateTime(new Date());
            wuziFafangService.insert(wuziFafang);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuziFafangEntity wuziFafang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wuziFafang:{}",this.getClass().getName(),wuziFafang.toString());
        WuziFafangEntity oldWuziFafangEntity = wuziFafangService.selectById(wuziFafang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            wuziFafang.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wuziFafangService.updateById(wuziFafang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WuziFafangEntity> oldWuziFafangList =wuziFafangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wuziFafangService.deleteBatchIds(Arrays.asList(ids));

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
            List<WuziFafangEntity> wuziFafangList = new ArrayList<>();//上传的东西
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
                            WuziFafangEntity wuziFafangEntity = new WuziFafangEntity();
//                            wuziFafangEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            wuziFafangEntity.setWuziId(Integer.valueOf(data.get(0)));   //物资 要改的
//                            wuziFafangEntity.setWuziFafangUuidNumber(data.get(0));                    //物资发放编号 要改的
//                            wuziFafangEntity.setWuziFafangNumber(Integer.valueOf(data.get(0)));   //发放数量 要改的
//                            wuziFafangEntity.setRukuTime(sdf.parse(data.get(0)));          //发放时间 要改的
//                            wuziFafangEntity.setWuziFafangAddress(data.get(0));                    //发放位置 要改的
//                            wuziFafangEntity.setWuziFafangContent("");//详情和图片
//                            wuziFafangEntity.setWuziFafangBeizhuContent("");//详情和图片
//                            wuziFafangEntity.setInsertTime(date);//时间
//                            wuziFafangEntity.setCreateTime(date);//时间
                            wuziFafangList.add(wuziFafangEntity);


                            //把要查询是否重复的字段放入map中
                                //物资发放编号
                                if(seachFields.containsKey("wuziFafangUuidNumber")){
                                    List<String> wuziFafangUuidNumber = seachFields.get("wuziFafangUuidNumber");
                                    wuziFafangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wuziFafangUuidNumber = new ArrayList<>();
                                    wuziFafangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wuziFafangUuidNumber",wuziFafangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //物资发放编号
                        List<WuziFafangEntity> wuziFafangEntities_wuziFafangUuidNumber = wuziFafangService.selectList(new EntityWrapper<WuziFafangEntity>().in("wuzi_fafang_uuid_number", seachFields.get("wuziFafangUuidNumber")));
                        if(wuziFafangEntities_wuziFafangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuziFafangEntity s:wuziFafangEntities_wuziFafangUuidNumber){
                                repeatFields.add(s.getWuziFafangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [物资发放编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wuziFafangService.insertBatch(wuziFafangList);
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
        PageUtils page = wuziFafangService.queryPage(params);

        //字典表数据转换
        List<WuziFafangView> list =(List<WuziFafangView>)page.getList();
        for(WuziFafangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuziFafangEntity wuziFafang = wuziFafangService.selectById(id);
            if(wuziFafang !=null){


                //entity转view
                WuziFafangView view = new WuziFafangView();
                BeanUtils.copyProperties( wuziFafang , view );//把实体数据重构到view中

                //级联表
                    YuangongEntity yuangong = yuangongService.selectById(wuziFafang.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
                //级联表
                    WuziEntity wuzi = wuziService.selectById(wuziFafang.getWuziId());
                if(wuzi != null){
                    BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWuziId(wuzi.getId());
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
    public R add(@RequestBody WuziFafangEntity wuziFafang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wuziFafang:{}",this.getClass().getName(),wuziFafang.toString());
        Wrapper<WuziFafangEntity> queryWrapper = new EntityWrapper<WuziFafangEntity>()
            .eq("yuangong_id", wuziFafang.getYuangongId())
            .eq("wuzi_id", wuziFafang.getWuziId())
            .eq("wuzi_fafang_uuid_number", wuziFafang.getWuziFafangUuidNumber())
            .eq("wuzi_fafang_number", wuziFafang.getWuziFafangNumber())
            .eq("wuzi_fafang_address", wuziFafang.getWuziFafangAddress())
//            .notIn("wuzi_fafang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WuziFafangEntity wuziFafangEntity = wuziFafangService.selectOne(queryWrapper);
        if(wuziFafangEntity==null){
            wuziFafang.setInsertTime(new Date());
            wuziFafang.setCreateTime(new Date());
        wuziFafangService.insert(wuziFafang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

