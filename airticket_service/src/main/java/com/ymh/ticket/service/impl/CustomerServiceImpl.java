package com.ymh.ticket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymh.airticket.entity.Customer;
import com.ymh.airticket.vo.PageQueryVO;
import com.ymh.ticket.mapper.CustomerMapper;
import com.ymh.ticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * TODO
 *
 * @author dreamer
 * @since 2024/12/4
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
//    @Autowired
//    private CheckgroupCheckitemMapper checkgroupCheckitemMapper;

    //分页条件查询检查项
    @Transactional(readOnly = true)
    @Override
    public Page<Customer> findPage(PageQueryVO vo) {
        //1.封装分页数据
        Integer currentPage = vo.getCurrentPage();
        Integer pageSize = vo.getPageSize();
        Page<Customer> page = Page.of(currentPage, pageSize);

        //2.封装查询条件
        String queryString = vo.getQueryString();
        LambdaQueryWrapper<Customer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtils.hasLength(queryString) , Customer::getIDNumber , queryString)
                .or()
                .like(StringUtils.hasLength(queryString) , Customer::getName , queryString);

        //3.执行分页条件查询
        Page<Customer> customerPage = this.baseMapper.selectPage(page, lambdaQueryWrapper);
        return customerPage;
    }

    //删除检查项
    @Transactional
    @Override
    public boolean del(Integer id) {
        //1.先关系表checkgroup_checkitem中查询当前检查项是否被占用，若被占用则抛出自定义异常
        LambdaQueryWrapper<Customer> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(!ObjectUtils.isEmpty(id) , Customer::getCustomerId , id);
//        Long count = checkgroupCheckitemMapper.selectCount(lambdaQueryWrapper);
//        if(count>0){
//            throw new AirticketException("当前检查项被占用！");
//        }

        //2.若未被占用，则执行删除操作
        int i = this.baseMapper.deleteById(id);
        return i>0?true:false;
    }
}
