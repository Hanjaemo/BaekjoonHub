# 2022년 4월 13일 
# 취소되지 않은 
# 흉부외과(CS) 진료 예약 내역


select ad.apnt_no, p.pt_name, p.pt_no, ad.mcdp_cd, ad.dr_name, ad.apnt_ymd from patient as p
join (
    select a.apnt_no, a.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd from doctor as d
    join (
        select * from appointment
        where date_format(apnt_ymd, '%Y-%m-%d') = '2022-04-13' and apnt_cncl_yn = 'N' and mcdp_cd = 'CS'
) as a on d.dr_id = a.mddr_id) as ad using(pt_no)
order by ad.apnt_ymd