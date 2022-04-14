package it.beije.turing.eserciziofile;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Giuseppe Raddato
 * Data: 12 apr 2022
 */
public class UtliForPrint {
     private List<Contact> result;

    public UtliForPrint(List<Contact> result) {
        this.result=result;
    }

    public List<String> getMaxLengthParams() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        if(result!=null){
            List<String> integers= new ArrayList<>();
            Contact c= result.get(0);

            for (String param: getParams()) {
                  int l= getMaxLengthParam(c.getClass().getDeclaredMethod("get"+param+""));
                    integers.add(String.valueOf(l));
            }
            return integers;
        }else{
            return null;
        }


    }

    private int getMaxLengthParam(Method method) throws InvocationTargetException, IllegalAccessException {
        int size=0;
        for (Contact r:this.result){
            int l=method.invoke(r).toString().length();
            if(l>size){
                size=l;
            }
        }
        return size;
    }

    public String[] getParams(){
        String[] str=null;
        List<String> lparam;
        if(result!=null){
            Contact c= result.get(0);
            List<Method> result = Arrays.asList(c.getClass().getDeclaredMethods());
            lparam = result.stream().
                    filter((method -> method.toString().contains("get"))).
                    map(method -> {
                       return method.toString().substring(
                        method.toString().indexOf("get"),method.toString().length()-2)
                               .replace("get","");
                    })
                    .collect(Collectors.toList());

            return lparam.toArray(new String[lparam.size()]);
        }else {
            return null;
        }

    }
}
