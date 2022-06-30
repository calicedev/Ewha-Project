SELECT DISTINCT TITLE,tbb.BWRITER, MODIFIED_DATE,tbb.bno
		FROM   tb_board tbb
		LEFT OUTER JOIN tb_reply tbr
                    ON( tbb.bno = tbr.bno )
		WHERE  tbr.bwriterid = 65
		