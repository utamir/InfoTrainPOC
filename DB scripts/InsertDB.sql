insert into db_sources values ('000000', 'SYSTEM', 1);

insert into resources (RESOURCE_LINK, DB_SOURCE) values ('http://pictures.topspeed.com/IMG/crop/200905/life-ball-mini-by-th_600x0w.jpg', '000000');
insert into resources (RESOURCE_LINK, DB_SOURCE) values ('http://fc09.deviantart.net/fs24/f/2008/030/4/a/Hippie_Van_by_hollywoodjazz.jpg', '000000');
insert into resources (RESOURCE_LINK, DB_SOURCE) values ('http://cs1.livemaster.ru/foto/large/441834788-kukly-igrushki-igralno-spalnyj-agregat-bibika-n5835.jpg', '000000');
insert into resources (RESOURCE_LINK, DB_SOURCE) values ('http://1.bp.blogspot.com/-mUBTI2SFyYg/T3nDb5x7DkI/AAAAAAAAOFI/oo5mXltSrec/s1600/1995-batman-forever-batmobile_54.jpg', '000000');
insert into resources (RESOURCE_LINK, DB_SOURCE) values ('http://www.oneill-injurysolicitors.co.uk/wp-content/uploads/bigstock-The-Tractor-Modern-Farm-Equi-44692394.jpg', '000000');
insert into resources (RESOURCE_LINK, DB_SOURCE) values ('http://sdelanounas.ru/i/d/3/d3d3LmNvbXBncmFtb3Rub3N0LnJ1L3dwLWNvbnRlbnQvdXBsb2Fkcy8yMDExLzA0L9C90YMt0L_QvtCz0L7QtNC4LTYuanBn.jpg', '000000');

--Brand logos
insert into resources (RESOURCE_LINK,DESCRIPTION, DB_SOURCE) values ('http://www.madesko.com/database/images/Cadillac%20Logo_L.gif','<brandName>Cadillac</brandName>', '000000');
insert into resources (RESOURCE_LINK,DESCRIPTION, DB_SOURCE) values ('http://www.madesko.com/database/images/Buick%20Logo%20Name_L.gif','<brandName>Buick</brandName>', '000000');
insert into resources (RESOURCE_LINK,DESCRIPTION, DB_SOURCE) values ('http://www.madesko.com/database/images/Chevrolet%20Logo_L.gif','<brandName>Chevrolet</brandName>', '000000');
insert into resources (RESOURCE_LINK,DESCRIPTION, DB_SOURCE) values ('http://www.sensethecar.com/wp-content/uploads/2011/05/GMC-Logo.png','<brandName>GMC</brandName>', '000000');
insert into resources (RESOURCE_LINK,DESCRIPTION, DB_SOURCE) values ('http://static.general-play.com/thumbs/e11/51/gp96d7bh1f5i0.jpeg','<brandName>Opel</brandName>', '000000');
insert into resources (RESOURCE_LINK,DESCRIPTION, DB_SOURCE) values ('http://carblueprints.info/design/images/logos/vauxhall-logo.png','<brandName>Vauxhall</brandName>', '000000');
insert into resources (RESOURCE_LINK,DESCRIPTION, DB_SOURCE) values ('http://carblueprints.info/design/images/logos/holden-logo.png','<brandName>Holden</brandName>', '000000');


insert into COUNTRY_CODES (ALPHA_CODE_2, ALPHA_CODE_3, NUMERIC_CODE, SORTKEY) values ('IL', 'ISR', 972, 0);
insert into COUNTRY_CODES (ALPHA_CODE_2, ALPHA_CODE_3, NUMERIC_CODE, SORTKEY) values ('US','USA',	1, 1);
insert into COUNTRY_CODES (ALPHA_CODE_2, ALPHA_CODE_3, NUMERIC_CODE, SORTKEY) values ('TH','THA',	66, 2);
insert into COUNTRY_CODES (ALPHA_CODE_2, ALPHA_CODE_3, NUMERIC_CODE, SORTKEY) values ('LK','LKA',  	94 , 3);
insert into COUNTRY_CODES (ALPHA_CODE_2, ALPHA_CODE_3, NUMERIC_CODE, SORTKEY) values ('IN','IND',  	91 ,4);
insert into COUNTRY_CODES (ALPHA_CODE_2, ALPHA_CODE_3, NUMERIC_CODE, SORTKEY) values ('NZ','NZL',  	64 , 5);

insert into REGIONS (LOCALE_ID, COUNTRY_CODE) values ('il', 'IL');
insert into REGIONS (LOCALE_ID, COUNTRY_CODE) values ('us', 'US');
insert into REGIONS (LOCALE_ID, COUNTRY_CODE) values ('th', 'TH');
insert into REGIONS (LOCALE_ID, COUNTRY_CODE) values ('lk', 'LK');
insert into REGIONS (LOCALE_ID, COUNTRY_CODE) values ('in', 'IN');
insert into REGIONS (LOCALE_ID, COUNTRY_CODE) values ('nz', 'NZ');


insert into operators (REGION_ID, locale_id, OPERATOR_NAME, DESCRIPTION, CURRENCY_CODE, CURRENCY_FORMAT, DATE_FORMAT, TIME_FORMAT) 
   values((select REGION_ID from regions where country_code = 'IL'), 'il', 'Israeli Operator', 'Operator in Israel', 'ILS','₪', 'dd-mm-yyyy', 'hh:mm:ss' );
insert into operators (REGION_ID, locale_id, OPERATOR_NAME, DESCRIPTION, CURRENCY_CODE, CURRENCY_FORMAT, DATE_FORMAT, TIME_FORMAT) 
   values((select REGION_ID from regions where country_code = 'US'), 'us', 'USA Operator', 'Operator in USA', 'USD','$', 'mm-dd-yyyy', 'hh:mm:ss' );
insert into operators (REGION_ID, locale_id, OPERATOR_NAME, DESCRIPTION, CURRENCY_CODE, CURRENCY_FORMAT, DATE_FORMAT, TIME_FORMAT) 
   values((select REGION_ID from regions where country_code = 'TH'), 'th', 'Thai Operator', 'Operator in Thailand', 'THB','฿', 'dd-mm-yyyy', 'hh:mm:ss' );
insert into operators (REGION_ID, locale_id, OPERATOR_NAME, DESCRIPTION, CURRENCY_CODE, CURRENCY_FORMAT, DATE_FORMAT, TIME_FORMAT) 
   values((select REGION_ID from regions where country_code = 'LK'), 'lk', 'Sri Lanka Operator', 'Operator in Sri Lanka', 'LKR','₨', 'dd-mm-yyyy', 'hh:mm:ss' );
insert into operators (REGION_ID, locale_id, OPERATOR_NAME, DESCRIPTION, CURRENCY_CODE, CURRENCY_FORMAT, DATE_FORMAT, TIME_FORMAT) 
   values((select REGION_ID from regions where country_code = 'IN'), 'in', 'Indian Operator', 'Operator in India', 'INR','₨', 'dd-mm-yyyy', 'hh:mm:ss' );
insert into operators (REGION_ID, locale_id, OPERATOR_NAME, DESCRIPTION, CURRENCY_CODE, CURRENCY_FORMAT, DATE_FORMAT, TIME_FORMAT) 
   values((select REGION_ID from regions where country_code = 'NZ'), 'nz', 'New Zealand Operator', 'Operator in New Zealand', 'NZD','$', 'dd-mm-yyyy', 'hh:mm:ss' );
   
   insert into VEHICLE_CATEGORIES (VEHICLE_CATEGORY_ID,DESCRIPTION) values ('Car','Passenger Car');
   insert into VEHICLE_CATEGORIES (VEHICLE_CATEGORY_ID,DESCRIPTION) values ('Van','Multi Passenger Vehicle');
   insert into VEHICLE_CATEGORIES (VEHICLE_CATEGORY_ID,DESCRIPTION) values ('Suv','Sport Utility Vehicle');
   insert into VEHICLE_CATEGORIES (VEHICLE_CATEGORY_ID,DESCRIPTION) values ('Truck','Truck');
   
   insert into VEHICLE_BRANDS (VEHICLE_BRAND_ID,BRAND_LOGO) values ('Cadillac',(select t.resource_id from resources t where t.description.extract('//brandName/text()').getStringVal() = 'Cadillac'));
   insert into VEHICLE_BRANDS (VEHICLE_BRAND_ID,BRAND_LOGO) values ('Buick',(select t.resource_id from resources t where t.description.extract('//brandName/text()').getStringVal() = 'Buick'));
   insert into VEHICLE_BRANDS (VEHICLE_BRAND_ID,BRAND_LOGO) values ('Chevrolet',(select t.resource_id from resources t where t.description.extract('//brandName/text()').getStringVal() = 'Chevrolet'));
   insert into VEHICLE_BRANDS (VEHICLE_BRAND_ID,BRAND_LOGO) values ('GMC',(select t.resource_id from resources t where t.description.extract('//brandName/text()').getStringVal() = 'GMC'));
   insert into VEHICLE_BRANDS (VEHICLE_BRAND_ID,BRAND_LOGO) values ('Opel',(select t.resource_id from resources t where t.description.extract('//brandName/text()').getStringVal() = 'Opel'));
   insert into VEHICLE_BRANDS (VEHICLE_BRAND_ID,BRAND_LOGO) values ('Vauxhall',(select t.resource_id from resources t where t.description.extract('//brandName/text()').getStringVal() = 'Vauxhall'));
   insert into VEHICLE_BRANDS (VEHICLE_BRAND_ID,BRAND_LOGO) values ('Holden',(select t.resource_id from resources t where t.description.extract('//brandName/text()').getStringVal() = 'Holden'));
   
   insert into VEHICLE_TYPES (VEHICLE_CATEGORY, VEHICLE_BRAND, VEHICLE_MODEL, MODEL_YEAR, THUMBNAIL_ID) 
        values ('Car','Chevrolet', 'Equinox', 2009,(SELECT resource_id FROM ( SELECT resource_id FROM resources ORDER BY dbms_random.value ) WHERE rownum = 1));
insert into VEHICLE_TYPES (VEHICLE_CATEGORY, VEHICLE_BRAND, VEHICLE_MODEL, MODEL_YEAR, THUMBNAIL_ID) 
        values ('Car','Chevrolet', 'Forester', 2010,(SELECT resource_id FROM ( SELECT resource_id FROM resources ORDER BY dbms_random.value ) WHERE rownum = 1));
insert into VEHICLE_TYPES (VEHICLE_CATEGORY, VEHICLE_BRAND, VEHICLE_MODEL, MODEL_YEAR, THUMBNAIL_ID) 
        values ('Car','Chevrolet', 'Corvette', 2011,(SELECT resource_id FROM ( SELECT resource_id FROM resources ORDER BY dbms_random.value ) WHERE rownum = 1));
insert into VEHICLE_TYPES (VEHICLE_CATEGORY, VEHICLE_BRAND, VEHICLE_MODEL, MODEL_YEAR, THUMBNAIL_ID) 
        values ('Car','Cadillac', 'ELR', 2014,(SELECT resource_id FROM ( SELECT resource_id FROM resources ORDER BY dbms_random.value ) WHERE rownum = 1));
insert into VEHICLE_TYPES (VEHICLE_CATEGORY, VEHICLE_BRAND, VEHICLE_MODEL, MODEL_YEAR, THUMBNAIL_ID) 
        values ('Truck','Cadillac', 'SRX', 2012,(SELECT resource_id FROM ( SELECT resource_id FROM resources ORDER BY dbms_random.value ) WHERE rownum = 1));
        
        
        
        insert into VEHICLES (OPERATOR_ID, VEHICLE_TYPE_ID, VEHICLE_VIN, LICENSE_PLATE, EXTERNAL_COLOR, INTERNAL_COLOR, DB_SOURCE) 
        values ((select operator_id from operators where locale_id='us'),
        (select vehicle_type_id from vehicle_types where vehicle_model = 'SRX'),
        '123456789', 'LIZOK', 'Red', 'Black', '000000');
        
        insert into VEHICLES (OPERATOR_ID, VEHICLE_TYPE_ID, VEHICLE_VIN, LICENSE_PLATE, EXTERNAL_COLOR, INTERNAL_COLOR, DB_SOURCE) 
        values ((select operator_id from operators where locale_id='us'),
        (select vehicle_type_id from vehicle_types where vehicle_model = 'Corvette'),
        '234567891', 'BORKA', 'Pink', 'Green', '000000');
        
                insert into VEHICLES (OPERATOR_ID, VEHICLE_TYPE_ID, VEHICLE_VIN, LICENSE_PLATE, EXTERNAL_COLOR, INTERNAL_COLOR, DB_SOURCE) 
        values ((select operator_id from operators where locale_id='us'),
        (select vehicle_type_id from vehicle_types where vehicle_model = 'Forester'),
        '345678912', 'TAMIR', 'Grey', 'Peach', '000000');
        
                insert into VEHICLES (OPERATOR_ID, VEHICLE_TYPE_ID, VEHICLE_VIN, LICENSE_PLATE, EXTERNAL_COLOR, INTERNAL_COLOR, DB_SOURCE) 
        values ((select operator_id from operators where locale_id='us'),
        (select vehicle_type_id from vehicle_types where vehicle_model = 'ELR'),
        '456789123', 'YUVAL', 'Yellow', 'Blue', '000000');
        
                insert into VEHICLES (OPERATOR_ID, VEHICLE_TYPE_ID, VEHICLE_VIN, LICENSE_PLATE, EXTERNAL_COLOR, INTERNAL_COLOR, DB_SOURCE) 
        values ((select operator_id from operators where locale_id='us'),
        (select vehicle_type_id from vehicle_types where vehicle_model = 'SRX'),
        '567891234', 'BARAK', 'Purple', 'Burgundy', '000000');
        
        insert into VEHICLES (OPERATOR_ID, VEHICLE_TYPE_ID, VEHICLE_VIN, LICENSE_PLATE, EXTERNAL_COLOR, INTERNAL_COLOR, DB_SOURCE) 
        values ((select operator_id from operators where locale_id='us'),
        (select vehicle_type_id from vehicle_types where vehicle_model = 'Equinox'),
        '678912345', 'ELIKO', 'Silver', 'Red', '000000');