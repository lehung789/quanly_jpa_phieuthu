package com.example.demo_jpa_phieuthu.Controller;

import com.example.demo_jpa_phieuthu.Model.NguyenLieu;
import com.example.demo_jpa_phieuthu.Repository.LoaiNguyenLieuRepo;
import com.example.demo_jpa_phieuthu.Repository.NguyenLieuRepo;
import com.example.demo_jpa_phieuthu.Services.NguyenLieuServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class NguyenLieuController {
    @Autowired
    NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    LoaiNguyenLieuRepo loaiNguyenLieuRepo;
    @Autowired
    NguyenLieuServices nguyenLieuServices;

    @RequestMapping(value = "nguyenlieu/themmoi",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public NguyenLieu themmoi (@RequestBody String nguyenlieumoi){
        Gson gson= new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
        NguyenLieu nguyenLieunew = gson.fromJson(nguyenlieumoi,NguyenLieu.class);
        return nguyenLieuServices.themNgyenLieu(nguyenLieunew);
    }
}
