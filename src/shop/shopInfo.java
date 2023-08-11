package shop;

import java.io.IOException;

public class shopInfo {
	public static void main(String[] args) {
        httpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://example.com/api/data"); // API 엔드포인트에 맞게 수정

        try {
            HttpResponse response = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(response.getEntity());

            // responseBody에는 서버로부터 받아온 데이터가 들어있습니다.
            System.out.println("Response from server: " + responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





