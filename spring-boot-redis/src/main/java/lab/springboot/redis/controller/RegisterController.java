package lab.springboot.redis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lab.springboot.core.controller.BaseController;
import lab.springboot.core.model.User;
import lab.springboot.core.util.ResultResponse;
import lab.springboot.redis.param.RegisterParam;
import lab.springboot.redis.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author liangchao.min
 *
 */
@Api("RegisterController 注册")
@RestController
@RequestMapping("/register")
public class RegisterController extends BaseController {

	@Resource
	private UserService userService;

	@ApiOperation(value = " 注册接口", notes = " 注册接口")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse<String> register(
			HttpServletRequest request,
			@ApiParam("{\"userName\":\"min\",\"password\":\"111111\"}") @ModelAttribute RegisterParam param) {
		try {
			if (null == userService.find(param.getUserName())) {
				User u = param.param2model();
				userService.save(u);
				return success("注册成功！");
			} else {
				return success("用户名已被注册！");
			}
		} catch (Exception e) {
			return error(e);
		}
	}

}
