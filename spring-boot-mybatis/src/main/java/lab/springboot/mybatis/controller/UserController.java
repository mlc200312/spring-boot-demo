package lab.springboot.mybatis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lab.springboot.core.controller.BaseController;
import lab.springboot.core.model.User;
import lab.springboot.core.param.Page;
import lab.springboot.core.util.ResultResponse;
import lab.springboot.mybatis.service.UserService;
import lab.springboot.mybatis.util.ModelUtil;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

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
			userService.deleteAll();
			return success("清除用户成功！");
		} catch (Exception e) {
			return error(e);
		}
	}

	@ApiOperation(value = " 分页查询用户", notes = "分页查询用户")
	@ApiResponses(value = { @ApiResponse(code = 200, message = RETURNMESSAGE) })
	@RequestMapping(value = "/queryUsersByPage", method = RequestMethod.POST)
	@ResponseBody
	public ResultResponse<Map<String, Object>> queryUsersByPage(HttpServletRequest request, @ModelAttribute Page page) {
		try {
			PageInfo<User> pageInfo = userService.queryByPage(page);
			return success(ModelUtil.toPage(pageInfo));
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
