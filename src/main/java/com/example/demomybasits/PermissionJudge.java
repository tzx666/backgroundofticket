package com.example.demomybasits;
import org.casbin.jcasbin.main.Enforcer;
public class PermissionJudge {
    public static String judge(String sub,String obj,String act){
        Enforcer e = new Enforcer("src/main/java/com/example/demomybasits/keymatch_model.conf"
                , "src/main/java/com/example/demomybasits/keymatch_policy.csv");
        // the user that wants to access a resource.
        // the resource that is going to be accessed.
         // the operation that the user performs on the resource.

        if (e.enforce(sub, obj, act) == true) {
            // permit alice to read data1
            System.out.println("权限通过");
            return "权限通过";
        } else {
            System.out.println("权限不足");
            return "权限不足";
            // deny the request, show an error
        }
    }
}
