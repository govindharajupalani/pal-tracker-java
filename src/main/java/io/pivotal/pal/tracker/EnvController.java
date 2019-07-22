package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController
{
    private String m_Port;
    private String m_MemLimit;
    private String m_Index;
    private String m_Address;

    public EnvController(@Value("${PORT:port_not_set}") String m_Port,
                         @Value("${memory.limit:mem_Not set}") String m_MemLimit,
                         @Value("${cf.instance.index:index_not_set}") String m_Index,
                         @Value("${cf.instance.addr:address_not_set}")String m_Address) {
        this.m_Port = m_Port;
        this.m_MemLimit = m_MemLimit;
        this.m_Index = m_Index;
        this.m_Address = m_Address;
    }

    @GetMapping("/env")
    public Map<String,String>  GetEnv()
    {
        Map<String , String > env = new HashMap();
        env.put("PORT",m_Port );
        env.put("MEMORY",m_MemLimit );
        env.put("CF_INSTANCE_INDEX",m_Index );
        env.put("CF_INSTANCE_ADDR",m_Address );

        return env;
    }

}