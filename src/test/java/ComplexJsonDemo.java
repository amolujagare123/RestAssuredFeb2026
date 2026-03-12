import io.restassured.path.json.JsonPath;
import org.junit.Assert;

public class ComplexJsonDemo {

    public static void main(String[] args) {

        String payLoad = "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"scriptinglogic.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "     {\n" +
                "      \"title\": \"Appium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "       \n" +
                "  ]\n" +
                "}\n";


        JsonPath jsonPath = new JsonPath(payLoad);


    //     1. Print No of courses returned by API

        int totalCourses = jsonPath.getInt("courses.size()");
        System.out.println("totalCourses="+totalCourses);

      //     2.Print Purchase Amount
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println("purchaseAmount="+purchaseAmount);

     //   3. Print Title of the first course
       String title1 =  jsonPath.getString("courses[0].title");

        System.out.println("title1="+title1);

    //    4. Print All course titles and their respective Prices

        for(int i=0;i<totalCourses ; i++)
        {
            String title =  jsonPath.getString("courses["+i+"].title");
            int price =  jsonPath.getInt("courses["+i+"].price");

            System.out.println("title="+title+"|"+" Price="+price);
        }


      //  5. Print no of copies sold by RPA Course

        for(int i=0;i<totalCourses ; i++)
        {

            String title =  jsonPath.getString("courses["+i+"].title");
            int copies;

            if(title.equalsIgnoreCase("RPA"))
            {
                copies =  jsonPath.getInt("courses["+i+"].copies");
                System.out.println("title="+title+"|"+" copies="+copies);
            }


        }
        

        //   6. Verify if Sum of all Course prices matches with Purchase Amount

        int sum = 0 ;

        for(int i=0;i<totalCourses ; i++)
        {

            int price =  jsonPath.getInt("courses["+i+"].price");
            int copies =  jsonPath.getInt("courses["+i+"].copies");

            sum = sum + (price*copies);
        }

        System.out.println("total purchase amount = "+sum);

        Assert.assertEquals("amount does not match",1162,sum);


    }
}
