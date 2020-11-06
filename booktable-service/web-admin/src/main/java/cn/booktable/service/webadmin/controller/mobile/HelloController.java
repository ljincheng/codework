package cn.booktable.service.webadmin.controller.mobile;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import cn.booktable.service.webadmin.utils.ViewUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import cn.booktable.core.view.JsonView;
import cn.booktable.util.AssertUtils;
import cn.booktable.exception.BusinessException;
import cn.booktable.service.webadmin.controller.base.BaseController;
import cn.booktable.core.page.PageDo;
import cn.booktable.modules.entity.mobile.HelloDo; 
import cn.booktable.modules.service.mobile.HelloService; 

/**
 * 
 * @author ljc
 */
@Controller
@RequestMapping("/mobile/hello")
public class HelloController extends BaseController{

	private static Logger logger= LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private HelloService helloService;
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/list")
	public ModelAndView list(){
		ModelAndView view=new ModelAndView("/mobile/hello/list");
		return view;
	}

	@PostMapping("/list")
	@RequiresPermissions("mobile:hello:list")
	public ModelAndView listTable(HttpServletRequest request,@RequestParam(required = false,defaultValue ="1")Long pageIndex,@RequestParam(required = false,defaultValue ="20")Integer pageSize,String startDate,String endDate){
	ModelAndView view=new ModelAndView("/mobile/hello/list_table");
		 Map<String,Object> selectItem = getRequestToParamMap(request); 
		 view.addObject("pagedata",helloService.queryHelloListPage(pageIndex,pageSize,selectItem));
		 return view;
	}

	@GetMapping(value="/add")
	public ModelAndView add(HttpServletRequest request){
		ModelAndView view=new ModelAndView("/mobile/hello/add");
		return view;
	}

	@PostMapping(value="/add")
	@RequiresPermissions("mobile:hello:add")
	public JsonView<String> add_POST(HttpServletRequest request,HelloDo helloDo){
		JsonView view=new JsonView();
		try{
			Integer dbRes= helloService.insertHello(helloDo);
			AssertUtils.isPositiveNumber(dbRes,"操作失败");
			ViewUtils.submitSuccess(view,messageSource);
		}catch (Exception ex) {
			ViewUtils.pushException(view,messageSource,ex);
			logger.error("添加异常",ex);
		}
		return view;
	}

	@GetMapping(value="/view")
	@RequiresPermissions("mobile:hello:view")
	public ModelAndView view(HttpServletRequest request,Long id){
		ModelAndView view =new ModelAndView("/mobile/hello/view");
		HelloDo helloDo= helloService.findHelloById(id);
		view.addObject("helloDo", helloDo);
		return view;
	}

	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(HttpServletRequest request,@PathVariable("id") Long id){
		ModelAndView view =new ModelAndView("/mobile/hello/add");
		HelloDo helloDo= helloService.findHelloById(id);
		view.addObject("helloDo", helloDo);
		return view;
	}

	@PostMapping(value="/edit/{id}")
	@RequiresPermissions("mobile:hello:edit")
	public JsonView<String> edit_POST(HttpServletRequest request,@PathVariable("id") Long id, HelloDo helloDo){
		JsonView view=new JsonView();
		try{
			helloDo.setId(id);
			Integer dbRes= helloService.updateHelloById(helloDo);
			//view.addObject("helloDo", helloDo);
			AssertUtils.isPositiveNumber(dbRes,"操作失败");
			ViewUtils.submitSuccess(view,messageSource);
		}catch (Exception ex) {
			ViewUtils.pushException(view,messageSource,ex);
			logger.error("编辑异常",ex);
		}
		return view;
	}

	@PostMapping(value="/delete")
	@RequiresPermissions("mobile:hello:delete")
	public JsonView<String> delete(HttpServletRequest request, Long id){
		JsonView<String> view=new JsonView<String>();
		try{
			AssertUtils.notNull(id, "参数无效");
			Integer result=helloService.deleteHelloById(id);
			AssertUtils.isPositiveNumber(result,"操作失败");
			setPromptMessage(view, view.CODE_SUCCESS, "操作成功");
		}catch (BusinessException e) {
			setPromptException(view, e);
		}catch (Exception ex) {
			logger.error("删除异常",ex);
			setPromptException(view, ex);
		}
		return view;
	}
}