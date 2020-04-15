package com.example.wenyb.service.impl;

import com.example.wenyb.domain.Boy;
import com.example.wenyb.enums.ResultEnum;
import com.example.wenyb.exception.BoyException;
import com.example.wenyb.service.BoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BoyServiceImpl implements BoyService {
    @Autowired
    private BoyService boyService;

    /**
     * 添加boy
     * @param boy
     */
    @Override
    public void addBoy(Boy boy) {
        boyService.addBoy(boy);
    }

    /**
     * 根据boy的id删除boy
     * @param id
     */
    @Override
    public void deleteBoy(Integer id) {
        boyService.deleteBoy(id);
    }

    /**
     * 根据boy的id编辑boy
     * @param boy
     */
    @Override
    public void editBoy(Boy boy) {
        boyService.editBoy(boy);
    }

    /**
     * 根据boy的id查询boy
     * @param id
     * @return
     */
    @Override
    public Boy searchBoy(Integer id) {
        return boyService.searchBoy(id);
    }

    public void searchAge(Integer id) throws Exception {
        Boy boy = boyService.searchBoy(id);
        Integer age = boy.getAge();
        if(age <12){
//            throw new Exception("你还在上小学吧！");
//            throw new BoyException(100,"你还在上小学吧");
            throw new BoyException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 12 && age < 18){
//            throw new Exception("你还在上中学吧！");
//            throw new BoyException(101,"你还在上中学吧");
            throw new BoyException(ResultEnum.MIDDLE_SCHOOL);
        }else{
//            throw new Exception("未知错误！");
//            throw new BoyException(-1,"未知错误！");
            throw new BoyException(ResultEnum.UNKONW_ERROR);
        }
    }

    /**
     * 查询boy列表
     * @return
     */
    @Override
    public List<Boy> searchBoyList() {
        return boyService.searchBoyList();
    }
}
