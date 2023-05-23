package com.example.demo_jpa_phieuthu.Controller;

import com.example.demo_jpa_phieuthu.Model.ChiTietPhieuThu;
import com.example.demo_jpa_phieuthu.Model.PhieuThu;
import com.example.demo_jpa_phieuthu.Repository.NguyenLieuRepo;
import com.example.demo_jpa_phieuthu.Repository.PhieuThuRepo;
import com.example.demo_jpa_phieuthu.Services.ChiTietPhieuThuServices;
import com.example.demo_jpa_phieuthu.Services.PhieuThuServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;


@RestController
public class PhieuThuController {
    @Autowired
    PhieuThuRepo phieuThuRepo;
    @Autowired
    PhieuThuServices phieuThuServices;
    @Autowired
    ChiTietPhieuThuServices chiTietPhieuThuServices;
    @Autowired
    NguyenLieuRepo nguyenLieuRepo;

    @RequestMapping(value = "phieuthu/chitietmoi", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ChiTietPhieuThu themmoichitiet(@RequestBody String chitietmoi) {
        Gson gson= new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();

        ChiTietPhieuThu chiTietPhieuThu =gson.fromJson(chitietmoi,ChiTietPhieuThu.class);

        return chiTietPhieuThuServices.phieuthumoi(chiTietPhieuThu);
    }
    @RequestMapping(value = "phieuthu/xoa",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public PhieuThu xoaphieuthu(@RequestParam int id){
        return phieuThuServices.remove(id);
    }
    @RequestMapping(value = "phieuthu/themmoi",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE )
    public PhieuThu themmoi(@RequestBody String phieuthumoi){
        Gson gson= new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        PhieuThu newphieuthu = gson.fromJson(phieuthumoi,PhieuThu.class);
        return phieuThuServices.themmoi(newphieuthu);
    }
    @RequestMapping(value = "phieuthu/laydulieu",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhieuThu> Get(@RequestParam int thang){
        return phieuThuServices.getMoth(thang);
    }
}
