package cn.booktable.service.webadmin.controller.sys;

import cn.booktable.exception.BusinessException;
import cn.booktable.modules.entity.sys.SysParamDo;
import cn.booktable.modules.service.sys.SysReviewService;
import cn.booktable.service.webadmin.controller.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author ljc
 */
@Controller
@RequestMapping("/sys/review/")
public class SysReviewController extends BaseController {
    private static Logger logger= LoggerFactory.getLogger(SysReviewController.class);

    @Autowired
    private SysReviewService sysReviewService;

    /**
     *
     * list:系统参数查询页面. <br>
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("/sys/review/list");
    }

    /**
     *
     * listData:系统参数查询数据. <br>
     * @param request
     * @return
     */
    @PostMapping("/list")
    @RequiresPermissions("sys:param:list")
    public ModelAndView listData(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("/sys/review/list_table");
        try {
            Map<String,Object> selectItem = getRequestToParamMap(request);
            selectItem.put("isValid", SysParamDo.ISVALID_T);
            String tableName="sys_review";
            model.addObject("pagedata",sysReviewService.querySysReviewList(selectItem,tableName));
        } catch (BusinessException e) {
            setPromptException(model, e);
        } catch (Exception e) {
            logger.error("获取系统参数列表异常", e);
            setPromptException(model, e);
        }
        return model;
    }
}
