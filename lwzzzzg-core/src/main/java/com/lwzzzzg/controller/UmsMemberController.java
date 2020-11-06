package com.lwzzzzg.controller;


import com.lwzzzzg.annotations.LoginUser;
import com.lwzzzzg.component.JwtHelper;
import com.lwzzzzg.result.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fmrx
 * @since 2020-11-05
 */
@RestController
@RequestMapping("/umsMember")
@Api(tags = "UmsMemberController", description = "用户接口")
public class UmsMemberController {

    @Autowired
    private JwtHelper jwtHelper;

    @ApiOperation("用户列表")
    @ApiImplicitParam(value = "用户id", dataType = "Integer", name = "userId", required = false)
    @PostMapping(value = "/list")
    public ResultVo list() {
        return ResultVo.success();
    }

    @ApiOperation("获取token")
    @ApiImplicitParam(value = "用户id", dataType = "Long", name = "userId", required = false, paramType = "query")
    @PostMapping(value = "/getToken")
    public ResultVo getToken(Long userId) {
        return ResultVo.success(jwtHelper.generateToken(userId));
    }


    @ApiOperation("验证Token")
    @PostMapping(value = "/verifyToken")
    @LoginUser
    public ResultVo verifyToken(@ApiIgnore String userId) {

        return ResultVo.success(userId);
    }




}
