package hippo.crisp.demo.components;

import org.apache.commons.lang.StringUtils;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.onehippo.cms7.essentials.components.EssentialsContentComponent;

/**
 * Created by jgreely on 3/12/18.
 */
public class TestComponent extends EssentialsContentComponent {

    private static String CODE_BASE_PATH = "/content/code/";
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response){
        String code = request.getParameter("c");
        if(StringUtils.isNotBlank(code)){
            String beanPath = CODE_BASE_PATH.concat(code);
            HippoBean bean = request.getRequestContext().getSiteContentBaseBean().getBean(beanPath);
            if(bean != null){
                request.setAttribute("document", bean);
            }
        }
    }
}
