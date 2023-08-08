package src.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RealTimeClock {

    public static void main(String[] args) {
        try {
            // NTP 서버 URL
            String ntpServerUrl = "http://worldtimeapi.org/api/timezone/Etc/UTC";
            
            // HTTP 요청 보내기
            URL url = new URL(ntpServerUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 응답 받기
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // JSON 형태의 응답에서 시간 정보 추출
                String jsonString = response.toString();
                // 여기서는 worldtimeapi.org의 응답 형식을 예로 들었습니다.실제 API에 따라 파싱 방법이 다를 수 있습니다.
                // JSON 파싱 라이브러리를 사용하면 편리하게 처리할 수 있습니다.
                String time = jsonString.substring(jsonString.indexOf("utc_datetime") + 15, jsonString.indexOf("utc_offset") - 3);

                System.out.println("실시간 시간: " + time);
            } else {
                System.out.println("HTTP 요청 실패 - 응답 코드: " + responseCode);
            }
            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}