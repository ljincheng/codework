package cn.booktable.cryptojs;

/**
 * @author ljc
 */
public class CryptoJSUtil {

    public static String DEFAULTKEY="__bcdef567kop48__";

    public static String decrypt( String input ) {

        return decrypt(input,DEFAULTKEY);
    }

    public static String decrypt( String input ,String splitKey) {

        String[] values = input.split( splitKey );
        // last element indicates indices
        String indices = values[values.length - 1];
        int[] indexes = convert( indices );
        SecurityInfo securityInfo = new SecurityInfo( values, indexes );
        SecurityUtil aesUtil = new SecurityUtil( securityInfo.getKeySize(), securityInfo.getIterationCount() );

        return aesUtil.decrypt( securityInfo.getSalt(), securityInfo.getIv(), securityInfo.getPassPhrase(), securityInfo.getCipherText() );

    }

    private static int[] convert( String indices ) {
        String[] indexes = indices.split( "," );

        int[] ints = new int[indexes.length];

        for ( int i = 0; i < indexes.length; i++ ) {
            String s = getNum( indexes[i] );
            ints[i] = SecurityInfo.getInt( s );
        }
        return ints;
    }

    private static String getNum( String s ) {
        switch ( s ) {
            case "a":
                return "0";
            case "b":
                return "1";
            case "c":
                return "2";
            case "d":
                return "3";
            case "e":
                return "4";
            case "f":
                return "5";
        }
        return s;
    }

    public static void main(String[] args) {
        String dl = "__bcdef567kop48__";
        // for string "test"
//        String s = "%63%38%61%38%33%37%62%33%31%64%2E%32%61%63%38__bcdef567kop48__1000__bcdef567kop48__4b30f6838362407954cb0cb0155f588f__bcdef567kop48__iCQ05Rkus2o/1i/2IaCooQ==__bcdef567kop48__4026c9cffa3567db126b3aaa70d0ea50__bcdef567kop48__128__bcdef567kop48__d,e,1,0,c,5";
        String s="VntbjJdZ15D+KzTvh1J4XA==__bcdef567kop48__1000__bcdef567kop48__128__bcdef567kop48__8ebafd637831bc18023c91e9749d2c1d__bcdef567kop48__4f411a7321e38c3446f5ec50e125bb0c__bcdef567kop48__%31%64%30%39%39%36%31%35%63%38%35%2E%35%61%36__bcdef567kop48__0,e,f,b,2,3";
        System.out.println("----dl = " + dl+"----s = " + s);
        System.out.println("s = " + decrypt(s));
    }
}
