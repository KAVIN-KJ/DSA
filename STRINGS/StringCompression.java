package STRINGS;
public class StringCompression {
    public int compress(char[] chars) {
        char cur = chars[0];
        int rl = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(c==cur){
                rl++;
            }
            else{
                sb.append(cur);
                if(rl>1) sb.append(rl+"");
                cur = c;
                rl = 1;
            }
        }
        sb.append(cur);
        if(rl>1) sb.append(rl+"");
        int i = 0;
        for(char c : sb.toString().toCharArray()){
            chars[i++] = c;
        }
        return sb.length();
    }
}
