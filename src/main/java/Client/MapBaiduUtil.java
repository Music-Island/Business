package Client;

import Model.Data;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.StandardSocketOptions;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取经纬度
 *
 * 获取之前需要访问http://lbsyun.baidu.com/获取密钥
 * 密钥："密钥字符串"
 */
public class MapBaiduUtil {
    public String Ak = "2vbhUL2Tsd4p3vYZ1cFazICalGjl2nks";
    public Data shuju_sj[] = new Data[10000];
    public ArrayList<ArrayList<Data>> sorted_sj = new ArrayList<>();
    public int tot =0;
//    public static void main(String[] args) throws IOException {
//        MapBaiduUtil getLatAndLngByBaidu = new MapBaiduUtil();
//
//        //Map<String,Double> map=getLatAndLngByBaidu.getLngAndLat("福建省福州市福州大学");
//        //System.out.println("经度："+map.get("lng")+"---纬度："+map.get("lat"));
//
//
//        getLatAndLngByBaidu.getName("福州市","购物.购物中心","美食");
//
//    }

    public void sort(){
        for(int i = 0;i < 4;i++) sorted_sj.add(new ArrayList<>());
        for(int i = 0;i < tot;i++){
            if(shuju_sj[i].price < 50) sorted_sj.get(0).add(shuju_sj[i]);
            else if(shuju_sj[i].price < 100) sorted_sj.get(1).add(shuju_sj[i]);
            else if(shuju_sj[i].price < 200) sorted_sj.get(2).add(shuju_sj[i]);
            else sorted_sj.get(3).add(shuju_sj[i]);
        }
        for(int i = 0;i < 4;i++)
            sorted_sj.get(i).sort(new Comparator<Data>() {
                                      @Override
                                      public int compare(Data o1, Data o2) {
                                          // TODO Auto-generated method stub
                                          if(o1.rating < o2.rating)
                                              return 1;
                                          else return -1;
                                      }
                                  });
    }
    public void get(){
        getName("福州市","购物.购物中心","美食");
        sort();
    }
    public void getName(String address,String tag,String query)
    {
        for(int i = 0;i<40;i++)
        {
            String url = "http://api.map.baidu.com/place/v2/search?query="+query+"&region="+address+"&output=json&scope=2&page_num="+i+"&ak="+Ak;
            String json = loadJSON(url);
            JSONObject obj = JSON.parseObject(json);
            if(obj.get("status").toString().equals("0")){

                JSONArray test = obj.getJSONArray("results");
                for(int i1 =0 ; i1< 10;i1++)
                {
                    JSONObject tt = test.getJSONObject(i1);
                    String t;
                    String name = tt.getString("name");
                    Integer price = tt.getJSONObject("detail_info").getDouble("price").intValue();
                    String addre = tt.getString("address");
                    Double rating = tt.getJSONObject("detail_info").getDouble("overall_rating");
                    String are = tt.getString("area");

                    if( !are.equals("仓山区")  && !are.equals("鼓楼区")  && !are.equals("台江区")  && !are.equals("长乐区")  && !are.equals("马尾区"))
                        continue;

                    if(name == null || price == null || addre == null || rating == null)
                        continue;
                    shuju_sj[tot++] = new Data(name,price,rating,addre);

                }
            }
        }
        System.out.println(tot);

    }
    public  Map<String,Double> getLngAndLat(String address){
        Map<String,Double> map=new HashMap<String, Double>();
        String url = "http://api.map.baidu.com/geocoder?address="+address+"&output=json&ak="+Ak;
        String json = loadJSON(url);
        JSONObject obj = JSON.parseObject(json);

        if(obj.get("status").toString().equals("OK")){
            double lng=obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
            double lat=obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
            map.put("lng", lng);
            map.put("lat", lat);
            System.out.println(obj);
        }else{
            System.out.println("未找到相匹配的经纬度！");
        }
        return map;
    }

    public static String loadJSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(), "UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
                //System.out.println(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }


}