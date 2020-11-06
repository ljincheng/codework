package cn.booktable.service.webadmin.controller.kids;

import cn.booktable.core.view.JsonView;
import cn.booktable.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ljc
 */
public class KidsDataController {

    private static Logger logger= LoggerFactory.getLogger(KidsDataController.class);

    @GetMapping(value="/test")
    public JsonView<String> test(HttpServletRequest request){
        JsonView<String> view=new JsonView<>();
        try{
            Map<String, Object> paramMap = new HashMap<>();
            Enumeration<String> keyNames = request.getParameterNames();
            if(StringUtils.isEmpty(request.getParameter("pageIndex"))){
                paramMap.put("pageIndex", "1");
            }
            if(StringUtils.isEmpty(request.getParameter("pageSize"))){
                paramMap.put("pageSize","20");
            }
            while (keyNames.hasMoreElements()) {
                String attrName = keyNames.nextElement();
                String attrValue = request.getParameter(attrName);
                logger.info("KEY: {}={}",attrName,attrValue);
            }
        }catch (Exception ex){
            logger.error("TEST:",ex);
        }
        return view;
    }

}
