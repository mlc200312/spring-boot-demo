package lab.springboot.mybatis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lab.springboot.core.controller.BaseController;
import lab.springboot.core.model.User;
import lab.springboot.core.util.ResultResponse;
import lab.springboot.mybatis.param.LoginParam;
import lab.springboot.mybatis.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author liangchao.min
 *
 */
@Api("LoginController 登录")
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Resource
	private UserService userService;

	@ApiOperation(value = " 登录", notes = " 登录")
	@ApiResponses(value = { @ApiResponse(code = 200, message = RETURNMESSAGE) })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse<String> login(HttpServletRequest request, @ApiParam("{\"userName\":\"min\",\"password\":\"111111\"}") @ModelAttribute LoginParam param) {
		try {
			User u = userService.find(param.getUserName());
			if (null != u && param.getPassWord().equals(u.getPassWord())) {
				request.getSession().setAttribute("user", u);
				return success("登录成功！");
			}
			return success("用户名密码不正确！");
		} catch (Exception e) {
			return error(e);
		}
	}

	@ApiOperation(value = " 登出", notes = " 登出")
	@ApiResponses(value = { @ApiResponse(code = 200, message = RETURNMESSAGE) })
	@RequestMapping(value = "/loginOut", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse<String> loginOut(HttpServletRequest request) {
		try {
			request.getSession().removeAttribute("user");
			return success("登出成功！");
		} catch (Exception e) {
			return error(e);
		}
	}

	@ApiOperation(value = "个人资料", notes = "个人资料")
	@ApiResponses(value = { @ApiResponse(code = 200, message = RETURNMESSAGE) })
	@RequestMapping(value = "/personalInfo", method = RequestMethod.GET)
	public ResultResponse<String> personalInfo(HttpServletRequest request) {
		User u = (User) request.getSession().getAttribute("user");
		if (null == u) {
			return success("请先登录！");
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(u);
			return success(json);
		} catch (JsonProcessingException e) {
			return error(e);
		}
	}

}
