package edu.npu.utils;

public class HexUtil {
	 // 4A 7D EB 69  
    // 74 125 235 105  
    public static final String bytesToHexString(byte[] bArray, int begin, int end) {  
        StringBuffer sb = new StringBuffer(bArray.length);  
        String sTemp;  
        for (int i = begin; i < end; i++) {  
            sTemp = Integer.toHexString(0xFF & bArray[i]);  
            if (sTemp.length() < 2)  
                sb.append(0);  
            sb.append(sTemp.toUpperCase());  
            sb.append(" ");  
        }  
        return sb.toString();  
    }  
}
