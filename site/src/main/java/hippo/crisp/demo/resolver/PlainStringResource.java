package hippo.crisp.demo.resolver;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.onehippo.cms7.crisp.api.resource.AbstractResource;
import org.onehippo.cms7.crisp.api.resource.ResourceCollection;
import org.onehippo.cms7.crisp.api.resource.ValueMap;
import org.onehippo.cms7.crisp.core.resource.DefaultValueMap;
import org.onehippo.cms7.crisp.core.resource.EmptyValueMap;


/**
 * Created by jgreely on 3/13/18.
 */
public class PlainStringResource extends AbstractResource {

    private String plainText;

    public PlainStringResource(String plainText){
        super(JsonNodeType.STRING.toString());
        this.plainText = plainText;
    }
    @Override
    public ValueMap getValueMap(){
        ValueMap map = new DefaultValueMap();
        map.put("string", plainText);
        return map;
    }

    @Override
    public ValueMap getMetadata() {
        return EmptyValueMap.getInstance();
    }

    @Override
    public ResourceCollection getChildren(long offset, long limit) {
        return null;
    }
}
