import { AbstractControl } from '@angular/forms'

export class Validate{

    static checkTax(c:AbstractControl){
        if(c.value <=0 || c.value>=1){
            return {rate:true}
        }
        return null;
    }

    static Idnumber(c:AbstractControl){
        if(c.value<=1){
            return {identification:true}
        }
        return null;
    }

}