package com.ymh.ticket.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ymh.airticket.entity.Checkitem;
import com.ymh.airticket.entity.Customer;
import com.ymh.airticket.vo.PageQueryVO;

public interface CustomerService extends IService<Customer> {
    Page<Customer> findPage(PageQueryVO vo);

    boolean del(Integer id);

}
