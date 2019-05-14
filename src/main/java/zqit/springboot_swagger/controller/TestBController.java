package zqit.springboot_swagger.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api("testB接口分发")
@RestController
@RequestMapping("/b")
public class TestBController {

	@GetMapping("/test1")
	@ApiOperation(value="test1方法", notes="返回名字")
	@ApiImplicitParam(paramType="query", name = "name", value = "名字", dataType = "String")
	@ApiResponse(code=100,message="name参数为空")
	public String test1(String name){
		if(StringUtils.isEmpty(name)){
			return "100";
		}
		return name;
	}
	
	@GetMapping("/test2")
	@ApiOperation(value="test2方法", notes="返回名字和年龄")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType="query", name = "name", value = "名字", required = true, dataType = "String"),
		@ApiImplicitParam(paramType="query", name = "age", value = "年龄", required = true, dataType = "Integer")
	})
	public String test1(String name, Integer age){
		return name + " -- " + age;
	}
}
