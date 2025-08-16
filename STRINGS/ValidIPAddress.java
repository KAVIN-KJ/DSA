package STRINGS;
import java.util.regex.*;
public class ValidIPAddress {
    public static void main(String[] args) {
        System.out.println(new Solution().validIPAddress("192.19.34.25.34.45"));
    }
}
class Solution {
    public String validIPAddress(String IP) {
        Pattern v4 = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]|[0-9])$");
        Pattern v6 = Pattern.compile("^([0-9a-fA-F]{1,4}\\:){7}[0-9a-fA-F]{1,4}$");
        if(v4.matcher(IP).matches()) return "IPv4";
        if(v6.matcher(IP).matches()) return "IPv6";
        else return "Neither";
    }
}