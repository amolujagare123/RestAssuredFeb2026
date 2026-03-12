package payload;

public class GoRestCrateUserPayLoad {

    public static String goRestPayLoad()
    {
        return "{\n" +
                "    \"name\": \"Aarav Mehta\",\n" +
                "    \"email\": \"aarav.mehta92@example.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}" ;
    }

    public static String goRestPayLoad(String name,String email,String gender,String status)
    {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"gender\": \""+gender+"\",\n" +
                "    \"status\": \""+status+"\"\n" +
                "}" ;
    }

}
