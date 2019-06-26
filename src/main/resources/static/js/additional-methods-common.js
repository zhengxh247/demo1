// 手机号码验证
jQuery.validator.addMethod("mobile", function(value, element) {
    var length = value.length;
    var mobile =  /^[1][3578]\d{9}$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "手机号码格式错误");   


// 电话号码验证   
jQuery.validator.addMethod("phone", function(value, element) {
    var tel = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
    return this.optional(element) || (tel.test(value));
}, "电话号码格式错误。电话号码格式 区号-电话号码-分机号");


// 邮政编码验证   
jQuery.validator.addMethod("zipCode", function(value, element) {
    var tel = /^[0-9]{6}$/;
    return this.optional(element) || (tel.test(value));
}, "邮政编码格式错误");


// QQ号码验证   
jQuery.validator.addMethod("qq", function(value, element) {
    var tel = /^[1-9]\d{4,9}$/;
    return this.optional(element) || (tel.test(value));
}, "qq号码格式错误");


// IP地址验证
jQuery.validator.addMethod("ip", function(value, element) {
    var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
}, "Ip地址格式错误");


// 字母和数字的验证
jQuery.validator.addMethod("chrnum", function(value, element) {
    var chrnum = /^([a-zA-Z0-9]+)$/;
    return this.optional(element) || (chrnum.test(value));
}, "只能输入数字和字母(字符A-Z, a-z, 0-9)");


// 中文的验证
jQuery.validator.addMethod("chinese", function(value, element) {
    var chinese = /^[\u4e00-\u9fa5]+$/;
    return this.optional(element) || (chinese.test(value));
}, "只能输入中文");

//中文姓名的验证
jQuery.validator.addMethod("chineseName", function(value, element) {
    var chinese = /^[\u4e00-\u9fa5]{1,6}$/;
    return this.optional(element) || (chinese.test(value));
}, "只能输入中文，长度1-6位");


// 下拉框验证
$.validator.addMethod("selectNone", function(value, element) {
    return value == "请选择";
}, "必须选择一项");


// 字节长度验证
jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {
    var length = value.length;
    for (var i = 0; i < value.length; i++) {
        if (value.charCodeAt(i) > 127) {
            length++;
        }
    }
    return this.optional(element) || (length >= param[0] && length <= param[1]);
}, $.validator.format("请确保输入的值在{0}-{1}个字节之间(一个中文字算2个字节)"));

// 字符验证   
jQuery.validator.addMethod("stringCheck", function(value, element) {   
  return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);   
}, "只能包括中文字、英文字母、数字和下划线");   
   
// 中文字两个字节   
jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {   
  var length = value.length;   
  for(var i = 0; i < value.length; i++){   
  if(value.charCodeAt(i) > 127){   
  length++;   
  }   
  }   
  return this.optional(element) || ( length >= param[0] && length <= param[1] );   
}, "请确保输入的值在3-15个字节之间(一个中文字算2个字节)");   
   
// 身份证号码验证   
jQuery.validator.addMethod("isIdCardNo", function(value, element) {   
  return this.optional(element) || isIdCardNo(value);   
}, "请正确输入您的身份证号码");   
    
// 手机号码验证   
jQuery.validator.addMethod("isMobile", function(value, element) {   
  var length = value.length;   
  var mobile = /^[1][3578]\d{9}$/;
  return this.optional(element) || (length == 11 && mobile.test(value));   
}, "请正确填写您的手机号码");   
    
// 电话号码验证   
jQuery.validator.addMethod("isTel", function(value, element) {   
  var tel = /^\d{3,4}-?\d{7,9}$/; //电话号码格式010-12345678   
  return this.optional(element) || (tel.test(value));   
}, "请正确填写您的电话号码");   
   
// 联系电话(手机/电话皆可)验证   
jQuery.validator.addMethod("isPhone", function(value,element) {   
  var length = value.length;   
  var mobile = /^[1][3578]\d{9}$/;
  var tel = /^\d{3,4}-?\d{7,9}$/;   
  return this.optional(element) || (tel.test(value) || mobile.test(value));   
   
}, "请正确填写您的联系电话");   
    
// 邮政编码验证   
jQuery.validator.addMethod("isZipCode", function(value, element) {   
  var tel = /^[0-9]{6}$/;   
  return this.optional(element) || (tel.test(value));   
}, "请正确填写您的邮政编码"); 

//增加身份证验证
function isIdCardNo(num) {
    var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var parityBit = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        return false;
    }
    // check and set value
    for (i = 0; i < intStrLen; i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i] * factorArr[i];
        }
    }

    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6, 14);
        if (isDate8(date8) == false) {
            return false;
        }
        // calculate the sum of the products
        for (i = 0; i < 17; i++) {
            lngProduct = lngProduct + varArray[i];
        }
        // calculate the check digit
        intCheckDigit = parityBit[lngProduct % 11];
        // check last digit
        if (varArray[17] != intCheckDigit) {
            return false;
        }
    }
    else {        //length is 15
        //check date
        var date6 = idNumber.substring(6, 12);
        if (isDate6(date6) == false) {
            return false;
        }
    }
    return true;
}
function isDate6(sDate) {
    if (!/^[0-9]{6}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    if (year < 1700 || year > 2500) return false
    if (month < 1 || month > 12) return false
    return true
}

function isDate8(sDate) {
    if (!/^[0-9]{8}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    day = sDate.substring(6, 8);
    var iaMonthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if (year < 1700 || year > 2500) return false
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1] = 29;
    if (month < 1 || month > 12) return false
    if (day < 1 || day > iaMonthDays[month - 1]) return false
    return true
}

jQuery.validator.addMethod("mobileOrEmail", function(value, element) {
    var length = value.length;
    var mobile =  /^[1][3578]\d{9}$/;
    var method1 = this.optional( element ) || /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/.test( value );
   	var method2 = this.optional(element) || (length == 11 && mobile.test(value));
   return method1 || method2;
}, "手机号或邮箱格式错误"); 

jQuery.validator.addMethod("numOrChar", function(value, element) {
    var method = /^[A-Za-z0-9]+$/;
   	return this.optional(element) || method.test(value);
}, "只能输入数字或者字母哦"); 