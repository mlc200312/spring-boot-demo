package lab.springboot.core.controller;

import lab.springboot.core.util.ResultResponse;

public class BaseController {

	protected static final String RETURNMESSAGE = "返回结果 -- code:000000(成功),code:000001(业务异常),code:100000(失败)";
	
	protected <T> ResultResponse<T> success() {
		return ResultResponse.success("", null);
	}

	protected <T> ResultResponse<T> success(T data) {
		return ResultResponse.success("", data);
	}

	protected <T> ResultResponse<T> error(Throwable e) {
		e.printStackTrace();
		return ResultResponse.error(e);
	}

}
