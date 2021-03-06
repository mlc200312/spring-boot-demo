package lab.springboot.redis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lab.springboot.core.controller.BaseController;
import lab.springboot.core.model.User;
import lab.springboot.core.util.ResultResponse;
import lab.springboot.redis.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author liangchao.min
 *
 */
@Api("UserController 后台用户")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Resource
	private UserService userService;

	@ApiOperation(value = " 清除所有用户", notes = "清除所有用户")
	@ApiResponses(value = { @ApiResponse(code = 200, message = RETURNMESSAGE) })
	@RequestMapping(value = "/clearUsers", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse<String> clearUsers(HttpServletRequest request) {
		try {
			userService.flushDB();
			return success("清除用户成功！");
		} catch (Exception e) {
			return error(e);
		}
	}

	@ApiOperation(value = " 分页查询用户", notes = "分页查询用户")
	@ApiResponses(value = { @ApiResponse(code = 200, message = RETURNMESSAGE) })
	@RequestMapping(value = "/queryUsersByPage", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse<List<User>> queryUsersByPage(
			HttpServletRequest request) {
		try {
			List<User> users = userService.findAll();
			return success(users);
		} catch (Exception e) {
			return error(e);
		}
	}

	@ApiOperation(value = "uid", notes = "uid")
	@ApiResponses(value = { @ApiResponse(code = 200, message = RETURNMESSAGE) })
	@RequestMapping(value = "/uid", method = RequestMethod.POST)
	@ResponseBody
	String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}

}
