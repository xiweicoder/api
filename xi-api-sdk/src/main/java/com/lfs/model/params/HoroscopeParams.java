package com.lfs.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: 西尾Ink
 * @Date: 2024年09月18日 12:37
 * @Version: 1.0
 * @Description: 随机一句情话
 */
@Data
@Accessors(chain = true)
public class HoroscopeParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;
    /**
     * 十二星座对应英文小写，aries, taurus, gemini, cancer, leo, virgo, libra, scorpio, sagittarius, capricorn, aquarius, pisces
     */
    private String type;
    /**
     * 十二星座对应英文小写，aries, taurus, gemini, cancer, leo, virgo, libra, scorpio, sagittarius, capricorn, aquarius, pisces
     */
    private String time;
}
