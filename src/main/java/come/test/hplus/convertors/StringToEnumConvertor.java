package come.test.hplus.convertors;

import come.test.hplus.beans.Gender;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;

public class StrongToEnumConvertor implements Converter<String, Gender> {
    @Override
    public Gender convert(String s) {
        if(s.equals("Male")){
            return Gender.MALE;
        }else if (s.equals("Female")){
            return Gender.FEMALE;
        }else{
            return Gender.OTHER;
        }


    }
}
