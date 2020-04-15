package com.example.wenyb.service;

import com.example.wenyb.domain.Boy;

import java.util.List;

public interface BoyService {
    /**
     * 添加boy
     * @param boy
     */
    public void addBoy(Boy boy);

    /**
     * 删除boy
     * @param id
     */
    public void deleteBoy(Integer id);

    /**
     * 修改boy
     * @param boy
     */
    public void editBoy(Boy boy);

    /**
     * 查询boy
     * @param id
     * @return
     */
    public Boy searchBoy(Integer id);


    /**
     * 查询boy列表
     * @return
     */
    public List<Boy> searchBoyList();
}
