public class OTP {
    String otp;
    OTP(){
        this.otp = ""+(int)Math.floor((Math.random()*10000)%10000);
        if(this.otp.length()<4){
            this.otp+=(int)Math.random()*10+"";
        }
        System.out.println("OTP Generated : "+this.otp);
    }
}
