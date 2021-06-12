package serg.restjs.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Act {
    //проверка правильная не правильная дробь
    public String todoCheck(int num, int denum){
        if(num>=denum){
            return "дробь "+num+"/"+denum+" не правильная";
        }

        return "дробь "+num+"/"+denum+" правильная";
    }
    //суммирование простых дробей
    public HashMap<String, Object> todoSum(int num1, int denum1, int num2, int denum2){
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "сумма дробей "+num1+"/"+denum1+" + "+num2+"/"+denum2);
        int num;
        int denum;
        if(denum1==0 || denum2==0){
            map.put("num", "делить на 0 нельзя");
            map.put("denum", "делит на 0 нельзя");
            return map;
        }
        else if(num1==0 && num2==0){
            map.put("num", 0);
            map.put("denum", denum1*denum2);
            return map;
        }
        else if(num1==0){
            map.put("num", num2);
            map.put("denum", denum2);
            return map;
        }
        else if(num2==0){
            map.put("num", num1);
            map.put("denum", denum1);
            return map;
        }
        else{
            denum = denum1*denum2;
            num = num1*denum2+num2*denum1;

        }

        map = todoReduction(num, denum);
        map.replace("type", "сумма дробей "+num1+"/"+denum1+" + "+num2+"/"+denum2);
        return map;
    }
    // вычитание простых дробей
    public HashMap<String, Object> todoSub(int num1, int denum1, int num2, int denum2){
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "вычитание дробей "+num1+"/"+denum1+" - "+num2+"/"+denum2);
        int num;
        int denum;
        if(denum1==0 || denum2==0){
            map.put("num", "делить на 0 нельзя");
            map.put("denum", "делит на 0 нельзя");
            return map;
        }
        else if(num1==0 && num2==0){
            map.put("num", 0);
            map.put("denum", denum1*denum2);
            return map;
        }
        else if(num1==0){
            map.put("num", num2);
            map.put("denum", denum2);
            return map;

        }
        else if(num2==0){
            map.put("num", num1);
            map.put("denum", denum1);
            return map;

        }
        else{
            denum = denum1*denum2;
            num = num1*denum2-num2*denum1;

        }

        map = todoReduction(num, denum);
        map.replace("type", "вычитание дробей "+num1+"/"+denum1+" - "+num2+"/"+denum2);
        return map;
    }

    // умножение простых дробей
    public HashMap<String, Object> todoMultiple(int num1, int denum1, int num2, int denum2){
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "умножение дробей "+num1+"/"+denum1+" * "+num2+"/"+denum2);
        int num;
        int denum;
        if(denum1==0 || denum2==0){
            map.put("num", "делить на 0 нельзя");
            map.put("denum", "делит на 0 нельзя");
            return map;
        }
        else if(num1==0 || num2==0){
            map.put("num", 0);
            map.put("denum", denum1*denum2);
            return map;
        }
        else{
            num = num1*num2;
            denum = denum1*denum2;
        }

        map = todoReduction(num, denum);
        map.replace("type", "умножение дробей "+num1+"/"+denum1+" * "+num2+"/"+denum2);
        return map;
    }
    //деление простых дробей
    public HashMap<String, Object> todoDiv(int num1, int denum1, int num2, int denum2){
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "деление дробей "+num1+"/"+denum1+" : "+num2+"/"+denum2);
        int num;
        int denum;
        if(denum1==0 || denum2==0 || num2==0){
            map.put("num", "делить на 0 нельзя");
            map.put("denum", "делит на 0 нельзя");
            return map;
        }
        else if(num1==0){
            map.put("num", 0);
            map.put("denum", denum1*num2);
            return map;

        }
        else{
            num=num1*denum2;
            denum = denum1*num2;
        }
        map = todoReduction(num, denum);
        map.replace("type", "деление дробей "+num1+"/"+denum1+" : "+num2+"/"+denum2);
        return map;
    }

    //сокращение дроби
    public HashMap<String, Object> todoReduction(int num, int denum){
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", "сокращение дроби "+num+"/"+denum);
        boolean boolNum = false;
        boolean boolDenum = false;
        // если кто то 0
        if(num==0 || denum==0){

            map.put("num", num);
            map.put("denum", denum);
            return  map;
        }
        // если отличаются знаками приводим к +
        if(num<0){
            num = -1*num;
            boolNum = true;
            }
        if(denum<0){
            denum = -1*denum;
            boolDenum = true;
        }
        //если числитель и знаменатель по модулю равны возвращаем 1 с учетом знака на входе
        if(num==denum){
            if(boolNum && boolDenum || !boolNum && !boolDenum){
                boolNum=false;
                boolDenum = false;
                map.put("num", 1);
                map.put("denum", 1);
                return  map;
            }
            if(boolNum && !boolDenum){
                boolNum=false;
                boolDenum = false;
                map.put("num", -1);
                map.put("denum", 1);
                return  map;
            }
            if(!boolNum && boolDenum){
                boolNum=false;
                boolDenum = false;
                map.put("num", 1);
                map.put("denum", -1);
                return  map;
            }
        }
        // основное сокращение, определяем кто меньший
        int min;
        if(num<denum){
            min=num;
        }
        else{
            min = denum;
        }

        while(min>1){
            if(num%min==0 && denum%min==0){
                num = num/min;
                denum = denum/min;
                break;
            }
            else{
                min = min-1;
            }
        }
        if(boolNum){
            num = -1*num;
            boolNum=false;
        }
        if(boolDenum){
            denum = -1*denum;
            boolDenum = false;
        }


        map.put("num", num);
        map.put("denum", denum);
        return  map;
    }
}
