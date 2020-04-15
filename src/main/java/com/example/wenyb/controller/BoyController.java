package com.example.wenyb.controller;

import com.example.wenyb.common.Result;
import com.example.wenyb.domain.Boy;
import com.example.wenyb.service.impl.BoyServiceImpl;
import com.example.wenyb.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BoyController {
    private final static Logger logger = LoggerFactory.getLogger(BoyController.class);
    @Autowired
    private BoyServiceImpl boyService;

    /**
     * 添加boy
     * @param boy
     */
    /*@PostMapping("/saveBoy")
    public void saveBoy(@Valid Boy boy, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }else{
            boyService.addBoy(boy);

        }

    }*/

    @PostMapping("/saveBoy")
    public Result<Boy> saveBoy(@Valid Boy boy, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
           /* Result<Boy> result = new Result<>();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            result.setData(null);
            return result;*/
           return ResultUtils.error(1,bindingResult.getFieldError().getDefaultMessage());
        }else{
            boyService.addBoy(boy);
            /*Result<Boy> result = new Result<>();
            result.setCode(0);
            result.setMsg("成功");
            return result;*/
            return ResultUtils.success();
        }

    }

    /**
     * 删除boy
     * @param id
     */
    @DeleteMapping("/deleteBoy/{id}")
    public void deleteBoy(@PathVariable("id") Integer id){
        boyService.deleteBoy(id);
    }

    /**
     * 编辑boy
     * @param boy
     */
    @PutMapping("/editBoy")
    public void editBoy(Boy boy){
        Boy boy1 = new Boy();
        boy1.setId(boy.getId());
        boy1.setName(boy.getName());
        boy1.setAge(boy.getAge());
        boyService.editBoy(boy1);
    }

    /**
     * 查询boy
     * @param id
     * @return
     */
    /*@GetMapping("/searchBoy/{id}")
    public Boy searchBoy(@PathVariable("id") Integer id){
        return boyService.searchBoy(id);
    }*/

    @GetMapping("/searchBoy/{id}")
    public Result<Boy> searchBoy(@PathVariable("id") Integer id){
//        return boyService.searchBoy(id);
        return ResultUtils.success(boyService.searchBoy(id));
    }

   /* @GetMapping("/searchBoyList")
    public List<Boy> searchBoyList(){
        logger.info("请求处理中#####");
        return boyService.searchBoyList();
    }*/

    @GetMapping("/searchBoyList")
    public Result<Boy> searchBoyList(){
//        return boyService.searchBoyList();
        return ResultUtils.success(boyService.searchBoyList());
    }
    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception {
       boyService.searchAge(id);
    }
}
