package str;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.text.*;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class StringUtils {

    public static HashMap<Integer, String> cloudImageResourceFilePaths = new HashMap<Integer, String>();


    public static String encodeStr = "WmhvbmVfOUFENA==," +
            "Q0FTQTIy," +
            "U2t5bmV0," +
            "RlJJVFohQm94IDY0OTAgQ2FibGU1," +
            "TkVUR0VBUjE0," +
            "VkNTTkVU," +
            "SEtNUDIwMTg=," +
            "amFydmlz," +
            "Tm8gSW50ZXJuZXQgRm91bmQ=," +
            "V1cwMDc=," +
            "OTg3Q0Ix," +
            "U29sZXh5X1dpRmk=," +
            "aHdBU1VT," +
            "U1BBIFRISUVOIEhVT05HX1Qx," +
            "c3VtbWVyIERyeQ==," +
            "dmlydXM=," +
            "R05BTkFNIEhPTUU=," +
            "MTU0WFJC," +
            "YzQ5OTAy," +
            "Sk9OQVRIQU4gNTA=," +
            "RlJFRV9VK3pvbmU=," +
            "66Gc7KeA7YWN," +
            "SW5mb3N0cmFkYS02RkRBQzY=," +
            "VGltbyAyLDQ=," +
            "UmVwZWxzdGVlbHRqZQ==," +
            "RElHSV9lMzBkMjI=," +
            "SHVnbw==," +
            "WmlnZ280MTU3NQ==," +
            "SGFhc2plcw==," +
            "U0tZTDNNREQ=," +
            "REFOREFOLg==," +
            "QkxUTjU=," +
            "Y2FzYQ==," +
            "dGVuZGFtZXNoX2hvbWU=," +
            "Vk02NTkxMzMx," +
            "V0xBTi1WRktFUk4=," +
            "RGlyayBlbiBBcmVuZGE=," +
            "WWFuZy0yLjRH," +
            "RlJJVFohQm94IDc1NjAgSlE=," +
            "Smlncw==," +
            "Um91dGVyV2VuRQ==," +
            "WmlnZ28zMTA4OTI4," +
            "VFBMSU5LLUFHU00=," +
            "VlJWOTUxN0M1RDNBOQ==," +
            "RmFtaWxpZVRpZW1lbnM=," +
            "S29uZHJ1cE5ldA==," +
            "RnJlZWRvbSBXaWZp," +
            "QXN1czIsNEdoeg==," +
            "eGFyaXM=," +
            "TUY5," +
            "TUlXSUZJX3VjeXk=," +
            "QnVyZ19GcmF1ZW5oYWdlbg==," +
            "TGl2ZWJveC04QzND," +
            "SU9U," +
            "RGVjb185NDg4," +
            "S1RfR2lHQV8yR19XYXZlMl9BMUVG," +
            "RlJJVFohQm94K0JBSFI=," +
            "V2lGaS0yLjQtOTk3Mg==," +
            "RlJJVFohQm94IDU0OTAgR1k=," +
            "SEFSSUNI," +
            "S3YgRXhtb3JyYQ==," +
            "QW5hcg==," +
            "RklHVUVST0EgWSBDSUEgTFREQQ==," +
            "Rmpvc2thbWVyYQ==," +
            "UkhEZWVtX1VucGx1Z2dlZA==," +
            "QmJveC00NTQzMTgzMw==," +
            "TGl2ZWJveDYtQzQxRA==," +
            "QWxpY2UtNTcxNjYzODk=," +
            "QVJSSVMtNDNGMQ==," +
            "RlVUQUxBVUZRVUVO," +
            "WmVnZXJz," +
            "TWF1cmk0MTI=," +
            "SG9tZW5ldA==," +
            "Wndhbmlra2Vu," +
            "UGVldEVuQmVlcldpcmVsZXNzTGVnYWN5," +
            "VlRSLTQ0NjI5MzQ=," +
            "TU9WSVNUQVJfQjJCRA==," +
            "V2lGaSBuZXR3ZXJrIHZhbiBhMTJtYXRqZTIxYQ==," +
            "S1BOOUYxOEE2," +
            "RnJpdHpCb3g3NTkwS3JldXo=," +
            "QVRUNTU0Ujl4NQ==," +
            "QVY=," +
            "cmFsZmx1ZnRAZ214LmRl," +
            "dGVsZW5ldC05NDIwMw==," +
            "RElHSV82YWQ5YzA=," +
            "U2VyaWVzIG9mIFR1YmVz," +
            "V2lGaV9PbGl2ZU5ldC1DRjA2QTQ=," +
            "TWFybG9lc0plbG1lcg==," +
            "WnlYZWxfTWFzdGVyX05ldHdlcms=," +
            "WmlnZ28wOTcyNDg1," +
            "dGVsZW5ldC0zNjIyM0U0," +
            "VFAtTGlua19EQ0I4," +
            "QkJT," +
            "YXV0aG9yaXplZGFjY2Vzc29ubHk=," +
            "Wm9u," +
            "REVSTUFORVQ=," +
            "RlJJVFohQm94IDc0OTAgQUI=," +
            "QW1vdWll," +
            "TU9ZT01V," +
            "WmlnZ280NTQ0OTYx," +
            "RnJlZWJveC1OQUhPVQ==," +
            "R28tR28gR2FkZ2V0LCBXSUZJIQ==," +
            "VENIb21l," +
            "UGlzY2luYSAtIEJ1bmdhbG93cyBEYWRh," +
            "Q09TTU9URS04NTU4NTY=," +
            "Q0FTQSBQSVBQTw==," +
            "aG9tZTIuNA==," +
            "VlRSLTUwMTgyNjE=," +
            "Qk9UVklSVVMy," +
            "QWFuZXNsYW5kIA==," +
            "RkxNNzI=," +
            "WHVlZnVSb2FkNzk=," +
            "UG93ZXJzRml0bmVzc0NlbnRlcg==," +
            "SHVzc2VpbkBSb2Vz," +
            "QVRUSlZCUGp5SA==," +
            "V2luZDMgSFVCLUU5NTZERA==," +
            "RmluaXN0ZXJyZQ==," +
            "SE9NRS05QUY0LTU=," +
            "VE9UT0xJTksgQUM1XzIuNEc=," +
            "WmlnZ280MDQ0OTE2," +
            "Rmpvc24=," +
            "dWlscG93ZXI=," +
            "QVNVUw==," +
            "d2lmaUBHYXN0aG9mLXp1ci1Qb3N0," +
            "VFAtTGlua19GNTI2," +
            "TUYyODZfMjg4RUQ3," +
            "U0NIUklFTUVSIDIuNEc=," +
            "QmFvS2hhbmggQmFvTG9uZw==," +
            "RmlicmUgUk9EUklHVUVa," +
            "RlJJVFohQm94IDQwNDAgUU4=," +
            "RlJJVFohQm94IDczNjIgU0w=," +
            "QnRIb21lX0V4dDJH," +
            "UHJveGltdXMtSG9tZS05NkQ2," +
            "RHVlUHVycHVyZmFyZ2V0," +
            "QVRULVdJLTg5NTc=," +
            "YmF0Y2F2ZQ==," +
            "TmluaG9EYUFndWlhSG91c2U=," +
            "SDM2OUE5OTEyRUU=," +
            "S2lsbGVydHVyayAyLjQgRw==," +
            "RG9taWs=," +
            "UGxheWdyb3VuZA==," +
            "SFVBV0VJLUIzMTEtRjkzQw==," +
            "d2xibTI0," +
            "RlJJVFohQm94IGJuLXQgMS01MDkxNDY=," +
            "Q2VudHVyeUxpbms1OTM3," +
            "MkctQVdJLTAxMjk2NA==," +
            "dGVsZW5ldC05Njc1RTQ5," +
            "NUctREhTLURyb25lNQ==," +
            "QWNjZXMtV2lyZWxlc3M=," +
            "RGVuIDUuMCBHWg==," +
            "QnJpZ2h0IFBhbmRh," +
            "TUs=," +
            "VGhlIG9uZQ==," +
            "dmFsaGFsbGE=," +
            "RmVhZWhvbWU=," +
            "U0ZSXzZFQTg=," +
            "T2JlcnVja2Vyc2VlTmV1," +
            "Q29sbGllXzVH," +
            "U2Fsb24gQ29udGU=," +
            "WmlnZ29ERTE4OTEy," +
            "WkFOWklCQVI=," +
            "UGVkcm8gTW9yYWxlcw==," +
            "SkRCX01BSU4=," +
            "VW5pZmk=," +
            "MjNQQUxNRVJORVQ=," +
            "R28gQ29mZmVlIERyLiBTZXplZnJlZG8=," +
            "TkVUXzQwNjY=," +
            "SG9tZV9NQl8yNA==," +
            "V2lGaS1BQkM=," +
            "RGlzY29yZGlhMjM=," +
            "VFAtTGlua18zM0Uw," +
            "WmlnZ29EQzk1MjQx," +
            "V29vbmthbWVy," +
            "SFVBV0VJLUNUMUpMNQ==," +
            "TGFhcmFra2Vycw==," +
            "emVlXzIuNA==," +
            "RlJJVFohQm94IDc1OTAgUlI=," +
            "Q1dDLTU0NTQ0Nzk=," +
            "RlJJVFohQm94IDc0OTA=," +
            "SGFwcHlGYWNl," +
            "SE9NRTE=," +
            "Wm9uZTE=," +
            "V29sdmVzIERlbg==," +
            "TWFub2JhbA==," +
            "U0JHNjcwMEFDLUIzRTYz," +
            "UmVkIFZvbGtzd2FnZW4=," +
            "RlJJVFohQm94IDY0OTAgQ2FibGU=," +
            "SDM2OUE4OEQ0QUM=," +
            "WmlnZ29BNzZFQTU0," +
            "U21hYXV0b3NhbGVz," +
            "Q1QgcG93ZXI=," +
            "Q2Fwcmljb3JuMDE=," +
            "V0xBTjEtMDAxNzUw," +
            "U2NvdHQtMTg=," +
            "QnJ5bmRhbGVAWmlnZ28yLDQgR0h6," +
            "UXVpY2t3aGFsZQ==," +
            "RGltb25hdg==," +
            "V0xBTi0yLDQ=," +
            "TGF2YW5kYQ==," +
            "SGplbQ==," +
            "S2FuYXJpZTI=," +
            "TGlua3N5czE2MzM3," +
            "V0ZfSE9NRQ==," +
            "V0ZfRE9N," +
            "U2thaWxhbmQxNQ==," +
            "QVRUZ05peGFLSQ==," +
            "Y2FwaWN1YQ==," +
            "RnJlZWJveC1BQjY5QUY=," +
            "TGl2ZWJveC1DQzUwX0VYVA==," +
            "TEFOIG9mIFN0ZWVsIDVH," +
            "U2FiYXRpZXI=," +
            "Vm9kYWZvbmUtMDgyMEFD," +
            "Rk1QX1BMVVM=," +
            "QmlsbGVrb3A=," +
            "RGFubmFo," +
            "VmlyeUd1aS01Rw==," +
            "dmlydXMx," +
            "aWNlLm5ldC02QUIyOTc=," +
            "MldJUkUwMTY=," +
            "QlJJVElTSA==," +
            "SGluZXQgSVAgTmV0," +
            "V2lmaTEy," +
            "R2FsbGVyeQ==," +
            "Zmlyb296MQ==," +
            "Y3JhenkgYmlyZCBsYWR5," +
            "cGF0YWdvbmlhLWpvbmF0aGFuLTIuNEc=," +
            "MDEwMDAwMDExMDAxMDExMDAxMDEwMDAwMQ==," +
            "Rmlvcy1ONU56Zg==," +
            "aHVnMmc1ODU4Njk=," +
            "c3Bj," +
            "YWJkbzVHSHo=," +
            "S29Lb0NoYW5lbA==," +
            "TkVUR0VBUjgz," +
            "S1RfV0xBTl8yQ0Yw," +
            "T1JCSTE5," +
            "VmVyaXpvbl9TOVpSUEQ=," +
            "T0ZJQ0lOQTI0LndpZmk=," +
            "R1JvdXRlcg==," +
            "SW50ZXJMQU4tQUpK," +
            "TG9zRnVtZXRhcw==," +
            "U2lsdmVyTW9vc2UgR3Vlc3QgMi40Rw==," +
            "RW1pbGlhMjA=," +
            "RmFtIEVuZ2Vscw==," +
            "Tmlja2k3MQ==," +
            "RmFtS3VpcGVycw==," +
            "c3RpamdlcmFydA==," +
            "QmVyZyAyLjQ=," +
            "VGVsaWEtQTM1Nzg3," +
            "bmlqYm9lcg==," +
            "S1RfR2lHQV8yR19XYXZlMl8yMUE2," +
            "VHJhdmVs," +
            "V2lGaSB2YW4gZGUgYnVyZW4=," +
            "WmlnZ282NzIxNDMwIGV4dHJh," +
            "RGUgTWVpc3Rlcg==," +
            "ZGxpbms=," +
            "U0FHQSAyMDE1," +
            "eGF2aWVyODZfMi40R2h6," +
            "Vk03OTY0NTkz," +
            "SDE1OC0zODFfNDY0QQ==," +
            "VlJWOTUxNzQ3NzY4OA==," +
            "T3B0dXMtNEctRTU1NzctRkI1RQ==," +
            "RnJpdHpFbHRl," +
            "SGVsaWE=," +
            "TkVMTA==," +
            "TWFuYXlhbmlrYWw=," +
            "d2hvJ3MgaXMgdGhpcz8/," +
            "Q09TTU9URS0xMzc5ODM=," +
            "d293amQ2MTE4," +
            "QVNVUzg2," +
            "VEhPLTI=," +
            "VFAtTElOS18zQzU1MUU=," +
            "RVY=," +
            "V2lGaS1BY2Nlc3M=," +
            "U0ZSX0QxNEY=," +
            "UFYxMEMtSU9U," +
            "RnJlZWJveC0zOEI0MEY=," +
            "QVAuTWl0b3Jhai5pbmRvb3I=," +
            "VGhhbyBOaHU=," +
            "TU9WSVNUQVJfUExVU19CMkJEXzIuNEdFWFQ=," +
            "V0xBTi1BdWVy," +
            "UFYxMEMtSU9U," +
            "ZmVua2FueW5saW5r," +
            "SDM2OUFGNjk2NkY=," +
            "WmlnZ29BMUY2ODZG," +
            "UHJpbnRpbmdQbHVzR2FzdA==," +
            "QWxjYXRlbCBMaW5rWm9uZV85RTE1," +
            "WmlnZ283RERGNTRC," +
            "SG9sbWVu," +
            "WWFuZ0x1bw==," +
            "dHJleGRvZw==," +
            "WmlnZ280NzlEQkIy," +
            "bWFhbG91bGE=," +
            "Q2hpbmFOZXQtNURDOA==," +
            "R01BQzE=," +
            "cHJpdmF0MTM3NmJsaQ==," +
            "TkVUR0VBUg==," +
            "Vm9kYWZvbmUtQzcxMw==," +
            "SE9MX1pURV82," +
            "VE1OTC01OTlERjE=," +
            "Y29qb2Nhcmlp," +
            "TG93aURCOTYtIDIsNCBHSHo=," +
            "RlJJVFohQm94IDc1MzAgWkQ=," +
            "X1J1bSBIYW0=," +
            "QnJvc1RyZW5kXzVHRVhU," +
            "U0tfV2lGaUdJR0FCNjc3," +
            "aG9tZWxhYi13YXAtNUctMQ==," +
            "SU5GSU5JVFk=," +
            "RGlydHkgRG9ua2V5IEZhcm1z," +
            "S1BOQjkzRjA2," +
            "VmVyaXpvbl80WkZUNlBfSW9U," +
            "U2Nob3BwZQ==," +
            "YXNzbWVqc19XaS1GaTU=," +
            "TXlBbHRpY2UgZTY2NjI4," +
            "aG8zYw==," +
            "U3lub2xvZ3lfMTQ2NDAw," +
            "Q09OLUFQ," +
            "S0xBQVNTRU5TIDI=," +
            "VFAtTGlua181RDdD," +
            "VFAtTGlua18zQTFD," +
            "cGFwdXNzYQ==," +
            "S2xhYXNqZXNfRVhU," +
            "VFAtTGlua18zODUw," +
            "S2VuJ3MgV2ktRmkgTmV0d29ya19FWFRfMi40R0h6," +
            "TkVUR0VBUjAx," +
            "U3RhbCBMaWV1d2VuZGFhbA==," +
            "TU9WSVNUQVJfNjRDRA==," +
            "TW9vMg==," +
            "SGFtYSBrYXdhbmk=," +
            "TXVuaWNo," +
            "Z2JBUDI=," +
            "TkhQMzg=," +
            "ZmF6ZW5kYQ==," +
            "RGVmYXVsdA==," +
            "U2VydmVyIFdPQ19FWFQ=," +
            "WmlnZ29BMkFFN0Y5," +
            "QlQtSEpGNlcz," +
            "U29sZXM=," +
            "TG9yZExhbmRlbW9ydA==," +
            "Vm9kYWZvbmUtQTgxNzczMTYw," +
            "T25lY29tMjgw," +
            "Q1EgQ1EgQ1E=," +
            "RmFtaWxsZVpvZGE=," +
            "VFAtTGlua180NzVB," +
            "VGFsbERvdmU=," +
            "SG90dHl0b2RkeQ==," +
            "Q2F0YWxpbmE=," +
            "c2xvd2J1cm4y," +
            "SW50b0lUX1I=," +
            "RGVub3lldHRlLSAyLjQtTg==," +
            "WmlnZ28zNDk2NjMy," +
            "cm9zZWxldF9wdWJsaWM=," +
            "TXlBbHRpY2UgMzY2ZmVi," +
            "TXlBbHRpY2UgZmZiMDli," +
            "c3R1ZmYyNA==," +
            "V2lGaSBDYXNhIE1hdg==," +
            "VFAtTGlua19FQTI3," +
            "RnJpZGkgRnJpdHogNzQ5MA==," +
            "SG9tZTEwMDA=," +
            "QkVDNEFB," +
            "Rm9ydHJlc3M=," +
            "RGlnaWNlbF9XaUZpX3RDSDI=," +
            "SVNLTy1BUDM=," +
            "U2hha3Rp," +
            "VFBIT05HMi40," +
            "Vm9kYWZvbmUgSG9tZXNwb3Q=," +
            "V2FseXJv," +
            "V1dXLU5FVC0yRw==," +
            "eGZpbml0eXdpZmk=," +
            "TW92aXN0YXIgQ2FzYQ==," +
            "UDFDb3JlQVA=," +
            "T1JCSTc3Nw==," +
            "czNvMg==," +
            "VGVsZW5vcl9GOTY4MTQ=," +
            "TWlsb19FWFQ=," +
            "RWwgdmFsbGU=," +
            "WmlnZ284NDcyNzAy," +
            "WlRFXzdFN1NCMg==," +
            "RlJJVFohQm94IDY0OTAgR2lzYmVydA==," +
            "TG9mdGNhdHM=," +
            "VGhlIEZvcmNlIElzIFN0cm9uZw==," +
            "Q29uY2EgRXh0," +
            "Ri1MRU9OMjAwMA==," +
            "QkFNQk9PXzJH," +
            "VElNLTI2NTAxMDE2," +
            "VFAtTGlua18wNTFD," +
            "aWlOZXQ1NDg2QTUtNUc=," +
            "UGx1bWU=," +
            "UHJpbnRpbmcgKw==," +
            "RmVsbGUgQmVhdSBNSw==," +
            "d2FsbHljaGV1bmc=," +
            "VmVyYmluZGluZw==," +
            "c2FuZHlWQUdJTkEyLjQ=," +
            "d2lmaSBrYXA=," +
            "VE1OTC02OTdDNDU=," +
            "VVBDMTI2MDg0MQ==," +
            "U2l0ZWNvbTQzRDJERQ==," +
            "VFAtTGluaw==," +
            "WmlnZ28xOTU4MTY5," +
            "cGhvdG9zaG9wcHJpbnQ=," +
            "dGVsZW5ldC1qYWFr," +
            "TU9WSVNUQVJfNDYxMg==," +
            "TWVzc2FnZXI=," +
            "TUVSQ1VSWV9GMTQ4ODg4," +
            "NUNQU01TRw==," +
            "RlJJVFohQm94IDc1OTAgTlI=," +
            "TW9ua2V5YnJhaW5zIEhvdHNwb3Q=," +
            "UFI=," +
            "VE1OTC1EMjBCQjE=," +
            "TGl2ZWJveC02Y2Q2," +
            "TW9uRWxpMkJlYg==," +
            "QlQtV1RBSFJL," +
            "RlJJVFohQm94IDc1OTAgT0c=," +
            "QWxpZW4=," +
            "dGFldzI1Mzk=," +
            "RmluY2EgQ2FuIExsb3AgV2lGaQ==," +
            "Qm9oc2U=," +
            "QVJSSVMtODc5QQ==," +
            "TWFyYyBGcml0emJveA==," +
            "QURFTUEgR3JvdXA=," +
            "U0ZSXzQ1QjA=," +
            "Vm9kYWZvbmUtNjQ4NDcz," +
            "bW92aXN0YXIyLDRHSFpfMkFFRkFG," +
            "VGVsZWNlbnRyby1lOWM3," +
            "RE5BLU1va2t1bGEtMkctRDY0NEhL," +
            "QWx0aWJveDc0MTAxMQ==," +
            "TUMzMTE1," +
            "SG9wcGVyX1dpRmk=," +
            "VFAtTGlua18yNDg0," +
            "QVRURE45bW1Hcw==," +
            "RlJJVFohQm94IDc1MzAgVUY=," +
            "Vk9PLVBTMFlaRDY=," +
            "S1RfR2lHQV83QjhC," +
            "WmlnZ281NEU1MThB," +
            "RlRUSF9PWjI0Nzg=," +
            "R3JpbmNobGFuZA==," +
            "QmxlaWNoaG9m," +
            "VGl3YXJpIGZhbWlseQ==," +
            "RXN0ZXJuYUVsZW5h," +
            "RnJlZWJveC0zNUNBNjc=," +
            "VmVnYUZpYnJhX0pwd0g=," +
            "QW1lcnNGb3J0ZQ==," +
            "T3JhbmdlX1N3aWF0bG93b2RfMjg5MA==," +
            "Tm90IFlvdXIgV0lGSQ==," +
            "RG8gUmUgTWkgRmEgU28gTGEgV2kgRmk=," +
            "VStOZXRBQUMz," +
            "c2hvcmU=," +
            "QmVya21vcnRlbCBNZXRhYWw=," +
            "QmJveC1XaWxs," +
            "SVpaSS03MTFG," +
            "RlJJVFohQm94IDU1MzAgRVY=," +
            "TG91bmdl," +
            "U2FzaG9fMQ==," +
            "RWFzeUJveC0yQ0M2NTg=," +
            "RGphbmdvU3Vpc3Nl," +
            "QmV0cmV1dGVzLVRyaW5rZW4=," +
            "VG9tQ2hhcg==," +
            "U2FzaG9fMg==," +
            "R29sb25kcmluYXMgNUc=," +
            "VFAtTGlua19BMzQ4," +
            "ZWljaGVuYXVlcmJ1ZXJv," +
            "TU9WSVNUQVJfNzFFRQ==," +
            "YWRtaW4=," +
            "TlNB," +
            "U3dlZXRGYXJtMQ==," +
            "QmFibw==," +
            "dmFud2VnZW4=," +
            "QWx0aWJveDUzMjE0N181Rw==," +
            "TkVUR0VBUjQ3," +
            "Vm9kYWZvbmVXSUZJLUNhc2FfRVhU," +
            "RUUtSHViLVQ0a0o=," +
            "VE1PQklMRS1CQUY0," +
            "U3BlY3RydW1TZXR1cC1BMA==," +
            "RlJJVFohQm94IDc1MzAgQ0M=," +
            "WlRFX0M4MjA5RQ==," +
            "QWRhbXNGYW1pbHk=," +
            "dmFud2VnZW4=," +
            "WmlnZ282NzUwMTM3," +
            "Znpjbw==," +
            "U3luQXBwMjAxMA==," +
            "SHl0dGVuZXR0," +
            "TWFyZ2l0aHVzZQ==," +
            "SG9tZSZMaWZlIFN1cGVyV2lGaS0xMTlD," +
            "VElNLTI2NTkyNTEzLTVHSHpfMl80R19FWFQ=," +
            "dEhlRGhBVFRz," +
            "Q0FTQVdJRkk=," +
            "V3ZKUy5Od0w=," +
            "SFVBV0VJLTIuNEctZnQ3Sw==," +
            "Q0FCTEVNVVJDSUEtMjdDNUE3," +
            "TWFsbGVwaWV0amU=," +
            "T3V0SGVuZHJpa3M=," +
            "SVpaSS0wMDQ0," +
            "QWx0aWJveDUzMjE0Nw==," +
            "Sk1CUzIwMTc=," +
            "SFVHVUVSSUU=," +
            "RkFNSUxJQU1PUkVOSVJJT1M=," +
            "Q0FN," +
            "SHViYmxl," +
            "SFVBV0VJLUI1MjUtOTM0Rg==," +
            "RkFTVFdFQi1COTM0QjU=," +
            "SDM2OUFFQTdFRTA=," +
            "aHJ0Zw==," +
            "c2t5bm9ydGhfNWc=," +
            "T1JCSTE4," +
            "Tmljb2xhcy1ldC1NYXVkZQ==," +
            "TkVUR0VBUjEz," +
            "QUxHSVo=," +
            "WmlnZ28yMTUyNDQ5," +
            "MldJUkUzNzgzMkdoeg==," +
            "MldJUkUzNzgz," +
            "QVNVU19HUDI=," +
            "VStOZXQ1RjYz," +
            "T1JCSTIw," +
            "U3BlY3RydW1TZXR1cC0wMA==," +
            "RlJJVFohQm94IDc1MzAgQVg=," +
            "UmVzdHJlcG8=," +
            "TGFib3JhbnRl," +
            "Um9nZXJzOTE=," +
            "VVA=," +
            "MTE5VGhlV29vZHNSZA==," +
            "Wnl4ZWwxNDMxOQ==," +
            "V00=," +
            "U3RvbmUgMi40Rw==," +
            "S1RfR2lHQV83MTAy," +
            "TWlsbw==," +
            "dHdjdnRqMjAwMA==," +
            "UmFpZGVyTmF0aW9u," +
            "UmVoYW4=," +
            "R2V0IHlvdXIgb3duIHdpcmVsZXNz," +
            "bW9uaXF1ZTM4MTg=," +
            "8J+mgw==," +
            "RnJvbnRpZXI2MTky," +
            "VHV1ayEh," +
            "MTcwMu2YuA==," +
            "d3lhdHR6YWNoZXJ5," +
            "aVBob25l," +
            "VEVMVVM0Q0JB," +
            "VXkncyBIb3VzZQ==," +
            "QjM1NjY0," +
            "VStOZXQ0NUQ4," +
            "UUM0," +
            "V2lmaS0yLjQtRTlEMg==," +
            "V0xBTi0yMDM2MTg=," +
            "Y21wdGh1aXM=," +
            "R2FzdA==," +
            "7L+g7YKk64Sk," +
            "QVRUSkJCVDRUQQ==," +
            "U0FTSE9fVFJJRk9OT1Y=," +
            "Qm91YnlzQm94," +
            "R05YOUVENUEy," +
            "QVAgMg==," +
            "Qk9VVElRVUU=," +
            "WmlnZ29GOTNGNUM5," +
            "TkVUXzJHOTY3RTlD," +
            "RmxvcHMtMi40Ry0zSHcz," +
            "QkVBU1RfMjRH," +
            "TGl2ZWJveC1FNkYw," +
            "U3Rld2JhbGw=," +
            "WmlnZ28xNjE2MDQw," +
            "RGlnaWJveC03Nzc2," +
            "VHJvbGwzNw==," +
            "RkFHSTE=," +
            "QFNJRF9QQVJBQ1VFTExPUw==," +
            "TWV5ZGFuIEtlYmFw," +
            "U2FibmV0Mkc=," +
            "d2NzajE=," +
            "dGluZ0V4dGVuZA==," +
            "Rm9ydHJlc3NPZlNvbGl0dWRl," +
            "TE9TIE5BUkFOSkFMRVM=," +
            "QVNQQU4=," +
            "d215dQ==," +
            "UzMy," +
            "Q2hlY2ttYXRlMTQzNw==," +
            "TmdvYyBIYW8=," +
            "TS4gSmFha2tl," +
            "SG9tZQ==," +
            "R1VFU1Q=," +
            "V2lGaS0yLjQtODA1MQ==," +
            "VFAtTGlua18yNjU4," +
            "RmVsbGUrQmVhdStNSw==," +
            "VGVsZW5vcjRHLTE0QTcxMw==," +
            "V2lGaSA4Ri0y," +
            "UWF6aW0gQ3VyYWo=," +
            "Vk9PLVQ0U1MzMEg=," +
            "SXVjYQ==," +
            "RnJpdHppLVR1bmRpbmc=," +
            "UG9vbA==," +
            "Q1lHTlVTQVRSQVRVUw==," +
            "dGVsZW5ldC0wMDRBNg==," +
            "QlRCSHViNi1RODlD," +
            "c2t5TGlmZV9XaUZpXzJHXzhFMTE=," +
            "Q2hhY2h1IEhvdXNpbmcgU2hvcA==," +
            "UExEVEhPTUVGSUJSRDIwMkI=," +
            "SDY1NDUwNTcgNEc=," +
            "Mk1SX3d3dy5teXN6a2EuZXVfdGVsLjYwNjgzNTgzNg==," +
            "VFAtTElOS18yMDIz," +
            "c3RlaW5zZXRuZXR0," +
            "RlJJVFohQm94IDY2NjAgQ2FibGUgSVg=," +
            "WmlnZ28zMTUwOTgy," +
            "QmVlbGR2ZXJoYWFs," +
            "UmlnbG9z," +
            "VE9DT01PQ0hP," +
            "Sm9oYW4gQ3J1aWpmZiBTdGFkaW9u," +
            "dWdhYm9vZ2E=," +
            "QlRCLU5QQ0dSTQ==," +
            "SG9mc3RlZQ==," +
            "U2FmZWluaG9tZQ==," +
            "V2lsbGlhTSd6IFVBUCA0Sw==," +
            "V2lsbGlhTSd6IFVBUCBIRA==," +
            "RlJJVFohQm94IDY4MjAgV0E=," +
            "Rmpvc25ldHQ=," +
            "TmlnaHRoYXdrMg==," +
            "bGlua2JyaWRnZTI=," +
            "RGVzcGFjaG8ubyw=," +
            "VklSR0lOLXRlbGNvXzUxMDJfNUc=," +
            "V0xBTi0zNjkzMDI=," +
            "c29ueSB0dg==," +
            "WmlnZ285MDUwOTE0," +
            "SG9yc2JhZWtrZW4gMjMgU3VydmVpbGxhbmNl," +
            "SmFLbyBNT0JJTEU=," +
            "em9uZWJveQ==," +
            "RGFydGggVmFkZXIgMi40IEdoeg==," +
            "SDM2OUE1NzQxOEM=," +
            "SGV5IFNpcmkgKDVHKQ==," +
            "RlJJVFohQm94IDc0OTA=," +
            "Q3Jpc3RhbGxvLVdpRmk=," +
            "NUcgemVuZG1hc3Q=," +
            "UkVQRQ==," +
            "bmF6YQ==," +
            "VGFza21hc3Rlcg==," +
            "SG9tZVN3ZWV0SG9tZV8y," +
            "aW90," +
            "VG9ieQ==," +
            "TGl2ZWJveC1ENDUw," +
            "VElNLTI5NzI2NzE5," +
            "ZW50aWRpYS1pb3Q=," +
            "Q2F0c29mdF9XTDI=," +
            "SFVBV0VJLTcyM0Y=," +
            "TGl2ZWJveCBTVC1NSUNIRUw=," +
            "TWF0ZQ==," +
            "QVRUNkh5ejNteQ==," +
            "U3BlY3RydW1TZXR1cC1FMA==," +
            "d2lmaWtpcmE1Rw==," +
            "V0xBTi05NDc0NTBH," +
            "WlRFXzNMRVYzMw==," +
            "UmV0ZS1DYXNh," +
            "SDM2OUE1QTMyNTI=," +
            "Q2FqYXNMQU4=," +
            "V0ZRQQ==," +
            "ZGxpbmstOTI5Mg==," +
            "V2lubmVyczIwMTA=," +
            "WmlnZ284MDExMzY4," +
            "U0VBRFJBR09O," +
            "T3JhbmdlLUYxNUY=," +
            "SGVsaWNvbiBDUw==," +
            "QmFzdGVu," +
            "U2tpYmEtMi40," +
            "QVZJU0FU," +
            "TVM=," +
            "dGNqdG5ldA==," +
            "MV85NjB0ZXN0," +
            "SDM2OUEzNzcxMEU=," +
            "VGVsY2VsLVpURS1NRjI5M04tOEI3MA==," +
            "SGFkZXM=," +
            "U3RlZW5TZWRpamtpZV8yLjRH," +
            "Q2FzYV9GZXJyZWlyYS1FWFQ=," +
            "RkFTVFdFQi1DQ1M0NTI=," +
            "RnJlZWJveC01QzM2MEQ=," +
            "TGVsa2Vzag==," +
            "QlAuTlc=," +
            "Wnl4ZWxfNTQ0RA==," +
            "S3Jpc3N5Lm5s," +
            "WmlnZ283OTc1Mzk1," +
            "SW50ZW5vLTYyMDI=," +
            "cG9rZW1vbg==," +
            "aW0gZm9jdXN0," +
            "R2VpbGVNZWxhbmV5," +
            "U0BOWUFS," +
            "QmVldGhvdmVu," +
            "U3BlY3RydW1TZXR1cC0yQg==," +
            "THVzdV81R0h6," +
            "TXlIb3VzZVdpRmk=," +
            "Q0FTQSBERUwgQ0FT," +
            "QnJpdm8=," +
            "V0lGSS1DSg==," +
            "QVRUWHF3WVZrbC01Rw==," +
            "Q2VudHVyeUxpbms3OTI1," +
            "RlJJVFohQm94IDc1OTAgWEE=," +
            "S3lsZTY3," +
            "VmlydHVhbA==," +
            "RlJJVFohQm94IEZvbiBXTEFOIDczNjAgU0w=," +
            "Q3J1dG9u," +
            "U2hhbm5vbg==," +
            "VGh4amFtZXM=," +
            "Tk9WQVBPTA==," +
            "Q3JhenlDbGFu," +
            "U21pdGhIb21lMjQ=," +
            "Sm9uYXRoYW4=," +
            "U21vb3RoNjM=," +
            "U0tfV2lGaUdJR0E2QkYwXzIuNEc=," +
            "VGhlUm9vc3Q=," +
            "c3l0ZWNzYQ==," +
            "eGZpbml0eTE=," +
            "VG9tYXRvMjQ=," +
            "TmFzaGxhIE1hcnRpbmV6," +
            "NzUwOEtQ," +
            "VFAtTElOS19BRjg4ODg4," +
            "U3VybG9w," +
            "VGVsZW5vcjRHXzFCOEU2NA==," +
            "c29ucmlzYXM=," +
            "RmxleCBPZmZpY2UgT2xkZW56YWFs," +
            "TWluV2lmaQ==," +
            "U3BlY3RydW1TZXR1cC0zMQ==," +
            "U1BBUkstWTM1WjMz," +
            "SHVnby1maWJlcg==," +
            "S3Jpc3R5bmE=," +
            "VFAtTElOS18xNEZB," +
            "dGF5bG9yIHN3aWZ0," +
            "VEsxOTk4," +
            "SFBSOA==," +
            "R05YODEwQTVG," +
            "UnVja3VzSDMyMC0yLjRHaHo=," +
            "Q09TTU9URS0xNTg0NDY=," +
            "aWxlbmNpa292Y2k=," +
            "SDM2OE45MTQ1RkM=," +
            "TmV0Q29tbSA3NTY3," +
            "SEFSTUVO," +
            "RUxOQQ==," +
            "MHhFOTk5QjNFN0JCQjQ=," +
            "Q2FidHJhbnMtVlBO," +
            "Z2lnYWN1YmUtRTY3OA==," +
            "U3BlaWt5MTI=," +
            "QmVhckJhcl9EcmVhbU1hY2hpbmU=," +
            "SDM2OUFDQzQxNDI=," +
            "UHJlY2lzZV8yLjRH," +
            "U0tfV2lGaUdJR0FEQ0QyXzIuNEc=," +
            "V0xBTi03OQ==," +
            "UElSRU1BUFU=," +
            "TWF4aW11cw==," +
            "TWljaGllbCBkZSBSb3V0ZXI=," +
            "SmVmZg==," +
            "RE9NT1RJQ0E=," +
            "VGVsZW5ldFdpRnJlZQ==," +
            "QWxhaXNoYS4=," +
            "U0tfV2lGaUYwQjk=," +
            "Vk03Njg1NzEy," +
            "Rlg=," +
            "TGlzZXMgaVBob25lIDEz," +
            "V2lmaVRlbHN1cl9HRU0=," +
            "RlJJVFohQm94IDc1NjAgWlMgMiw0IEdoeg==," +
            "V0xBTi04OVM0QVg=," +
            "RnJhbmNlc2NvX0ZXQQ==," +
            "SmFtZXMgQXdlc29tZSBOZXQ=," +
            "WmlnZ285MzEyODU2," +
            "QVJSSVMtNTBGMg==," +
            "TGl2ZWJveC1EQTIw," +
            "dmFuSG9vaWpkb25r," +
            "TUlXSUZJX1pRS3U=," +
            "VFAtTGlua18yRTRD," +
            "WmlnZ28zNjUyOTQ0," +
            "V3Via2VzIFdpRmk=," +
            "ZmF0YWwgZXJyb3I=," +
            "bWV3aWZp," +
            "V2Fsa2VySG9tZQ==," +
            "aWlOZXQ1NDg2QTUtNUdfMi40Rw==," +
            "QnNwYWNl," +
            "UGVhY2h5IEtlZW4=," +
            "RnJvbnRpZXI4OTc2," +
            "VGVsc3RyYTBEM0NEOQ==," +
            "ZGFuZ2VyISEhISE=," +
            "V2luazRzaG9ydA==," +
            "V2FybmluZyEhIDop," +
            "VmVyaXpvbl9TNk5SRkQ=," +
            "S29uaWpuZW5iZXJn," +
            "T1JCSUpHSE9NRQ==," +
            "S0s=," +
            "QmVsaXplLTI=," +
            "ZnJlZWJveDc1," +
            "a29uQHdpZmk=," +
            "cGVlbGtyb29uX2dhc3Q=," +
            "SW1vIGFuZCBMdWNl," +
            "RmxlZXRfV2lGaS0y," +
            "TmluamFUdXJ0bGVz," +
            "SGVpamRlbi1XSUZJ," +
            "aWNvbnBhdGg=," +
            "SFVBV0VJX0U1NTc2XzZGQUQ=," +
            "VkFMRU5DSUE=," +
            "dm9kYWZvbmVBRkQ1Qjk=," +
            "T25ldHRv," +
            "UG9uQmFv," +
            "QVNVUzUwMw==," +
            "Q09HRUNPLUVFRUI=," +
            "WmlnZ285NjAxMzgx," +
            "Rm9yc3l0aGllbnN0cmF1Y2g=," +
            "U0lOR1RFTC1FRTdC," +
            "QWxsZW5KSG9tZQ==," +
            "QFBISUNPTU1fMDk=," +
            "dWxhbmQ=," +
            "S1BOUGV0MjQ=," +
            "WmlnZ28xMDg5MjE3," +
            "RGFya19Nb29uX2pi," +
            "TGl2ZWJveC01REMw," +
            "U0tfV2lGaUdJR0EwQkVCXzIuNEc=," +
            "aG9tZSB0ZWxlbmV0LTcxQUNC," +
            "S2Fzc2FfdmFuX1BPU3N5c3RlbXM=," +
            "RnJlZC16aWdnby01Rw==," +
            "dGVsZW5ldC02NDc5ODg5," +
            "QnVkZGllcyBkbGluazI=," +
            "VFAtTElOS18zNUJD," +
            "QmlGaQ==," +
            "S1RfR2lHQV9EOUEw," +
            "QWx0aWJveDMwNTk1Mg==," +
            "Qm94XzYzMzM0," +
            "TWlGaSAyLjQ=," +
            "S1RfR2lHQV8yR19XYXZlMl8xRTc0," +
            "QUFMQVBFTExFU1JM," +
            "bm9tYWRzZW91bA==," +
            "T3B0dXNfQkFFNDRD," +
            "VFAtTGlua18zMjhB," +
            "SGFicnUtcGVyc29uZWVs," +
            "YXJfRkI3NTgx," +
            "Vm9kYWZvbmVTYWxh," +
            "VlJWOTUxNzM3QTY5OA==," +
            "TUlXSUZJXzdzcDY=," +
            "WllYRUwtU2Vpbm5p," +
            "WllYRUwtRnlycmk=," +
            "b2xsZWhfV2lGaV9ERUJE," +
            "aGplbW1lbmV0dA==," +
            "TU9NMQ==," +
            "TU9WSVNUQVJfMDEwNg==," +
            "TGluZGVsYWFuMTE=," +
            "TW9iaWxlIFdpRmktOE10RnFW," +
            "a3NrIHN0ZWVuYnJ1Z2dl," +
            "TEVMWV9OZXR3b3Jr," +
            "dGVsZW5ldC03QkVCMzgy," +
            "QmxhY2tTdGVhbHRoMDg3MjM=," +
            "RC1XaXJlbGVzcw==," +
            "Y2VudGVyX2VhcnRo," +
            "U3BjMi40X0VYVA==," +
            "RlJJVFohQm94IFlVUw==," +
            "dmFsc2VycmFubw==," +
            "SkVOTklGRVItUENfTmV0d29yaw==," +
            "U1VOQ0hJTkUgUEM=," +
            "VFAtTElOS183ODEw," +
            "Tmlra2lTY3VkZHM=," +
            "S1BOMEY4M0U2," +
            "V0xBTi01MTI5MjU=," +
            "QWlycG9ydCBCdXJn," +
            "QVJWNzUxOTc4NkM2QQ==," +
            "dGVsZW5ldC01ODcxMDk4," +
            "VmFuSGVz," +
            "RmliZXJuZXQtNjA3MzQ2NDg=," +
            "V2lmaW5ldHdlcmsgdmFuIGphY2NvIDIgYm92ZW4=," +
            "UiZEIEhPVVNF," +
            "SlRfMi40R0VYVA==," +
            "TkVUR0VBUjAxLTVH," +
            "RU9MTyAtIEZSSVRaIUJveCA0MDIwIEZO," +
            "RnJpdHo=," +
            "S1BOMzYxMjk2," +
            "ZXNzbGluZ2Vy," +
            "aWNlLm5ldC03NUQwNEI=," +
            "SG9tZVN3ZWV0SG9tZQ==," +
            "RkFTVFdFQi1jbWYzR0Y=," +
            "QVRUNTZVUHk4WA==," +
            "bWlzc2k=," +
            "QUIyMA==," +
            "RUJDMTMw," +
            "U2Vi," +
            "VE9CWQ==," +
            "ZGxpbmstMjMzQw==," +
            "RnJlZWJveC1BMEQ5MDE=," +
            "TUlUTE9DQUw=," +
            "ZmFybQ==," +
            "TWFnZW50YVdMQU4tV1JDSA==," +
            "R3JlYXQgRGF5," +
            "WmlnZ29DNTMyNDUx," +
            "ZGxpbmstNDI2Qw==," +
            "V29sZjI=," +
            "TmlraQ==," +
            "Z290dGE=," +
            "VFAtTGlua183MzdD," +
            "U2t5d2Fsa2Vy," +
            "RElHSV84Y2QwNTI=," +
            "dGVsZW5ldC03MjE5NzY1," +
            "ZGVjbw==," +
            "QXVkaSBJNSBVVyAoMik=," +
            "TkVUR0VBUjIz," +
            "WXdhbk5ldA==," +
            "YWoy," +
            "Q294V2lGaQ==," +
            "a29jY28tMkc=," +
            "SGFzZWxiZWtrZQ==," +
            "Q1ctV29yaw==," +
            "SmFubmVh," +
            "TUFSQVRIT04=," +
            "VGhlTWlnaHR5T0FL," +
            "Um9nbmJv," +
            "Y2FzaXRh," +
            "TkVUR0VBUjk5LTVH," +
            "Q2FybTEyNjk1," +
            "VStOZXRBN0Y5," +
            "S29uc3RhbnRpbm9zIFBhcnRuZXJz," +
            "VWJpcXVpdGk=," +
            "V0xBTi03MjgyNDk=," +
            "TkVUR0VBUjQw," +
            "TXlTcGVjdHJ1bVdpRmlmOS0yRw==," +
            "U25vd0Rlc2VydFByb2R1Y3Rpb25zXzIuNEc=," +
            "QVAgMg==," +
            "SGVsbG9Xb3JsZA==," +
            "RDIxMzBD," +
            "bHluc2t5," +
            "VGhlIHZvbi1LZW1wa2Fz," +
            "QmlsbCBXaSB0aGUgU2NpZW5jZSBGaQ==," +
            "S1RfR2lHQV85QTA3," +
            "TXlTcGVjdHJ1bVdpRmk2OC0yRw==," +
            "TGl2ZWJveC0wQkQw," +
            "RnJlZWJveC0xRTY2QUYtSkNs," +
            "UmVnZW5oYXViZQ==," +
            "UmlraGVpbV8yLjRHSHo=," +
            "TWFnaW5vbl9NZXNoR29fMzMzNg==," +
            "WmlnZ284OTc5MTky," +
            "TGl2ZWJveC1yb2J5," +
            "UGFpZXJsX0h5YnJpZF9HaHo=," +
            "RlJJVFohQm94IDc1MzAgV1U=," +
            "VmVyaXpvbl85NFNQWDk=," +
            "TGl2ZWJveC0xNUU0," +
            "RmlPUy1ONEFZWQ==," +
            "aG9tZQ==," +
            "V2lmaSB2YW4gTWFyaWFubmU=," +
            "TWFydFdpRmktNUc=," +
            "VGVsaWEtNDRBNjA1," +
            "U0tZTU0zVlI=," +
            "QWFyb24=," +
            "UHVja2V0dCByZCB3aWZp," +
            "U1A=," +
            "Q2FzYSBEaSBHaWFjb21v," +
            "U3BjNQ==," +
            "S1BONjBCMkU2," +
            "QmVuamFtaW5zLUlvVA==," +
            "Qm9ycmVsbG8=," +
            "R29vZ2xl," +
            "TGl2ZWJveDYtRDUzRg==," +
            "Qm91d2Vycw==," +
            "SGVyb2Vz," +
            "VE1OTC02RDlBRUQ=," +
            "d29sZg==," +
            "RnJlZWJveC1BMkQzMTE=," +
            "RUxKTyA1MCA1Rw==," +
            "VlRSLTA1NjgyMzU=," +
            "RmliZXJ0ZWwgV2lmaSAyLjQ=," +
            "Sm9zZSB3aWZp," +
            "V2lGaV92YW5fR2lubmVrZW4=," +
            "QmJveC04NEM2QzkzQw==," +
            "QWx0aWJveDM4NjU4OQ==," +
            "VGVsZWNlbnRyby1jMThi," +
            "V2lGaS1CQjIx," +
            "U0tfV2lGaUdJR0E3M0EwXzIuNEc=," +
            "TXkgSG91c2U=," +
            "SVBUSU1F," +
            "REggT2ZmaWNl," +
            "b3Jhbmdl," +
            "R29vZGZvb3Rpbg==," +
            "TmFzYmVyZ2V0IDU0OTQ=";


    public static String encode2 = "" +
            "VmVyaXpvbl9TNk5SRkQ=," +
            "TG92ZUdvbGlhdGgz," +
            "VE9LQU1BSw==," +
            "d2VyaWJvQGhvdG1haWwuY29t," +
            "SGVpbXdlaExBTg==," +
            "VGVjaEBmb3Njb20uY29t," +
            "Q2hpbmFOZXQtTG5nQQ==," +
            "VFAtTGlua183REZD," +
            "VkdWNzUxOTUyRjY5Rg==," +
            "VG9zc2EyNDEx," +
            "RmxlZXRfV2lGaS0y," +
            "S1RfR2lHQV81R19CMTY4," +
            "R05YRTI5QTk3," +
            "VE1OTC1FRTUzRTE=," +
            "RnJlZWJveC1BMEQ5MDE=," +
            "TXlPcHRpbXVtIDhhNjY2Zg==," +
            "VVBDNTcxOTY3OA==," +
            "Q2FsbGF3YXk=," +
            "Q2FmZS1XZWltYXI=," +
            "QURBTU8tSFI1Tg==," +
            "U0tfV2lGaUdJR0EyRjg2XzIuNEc=," +
            "RlJJVFohQm94IDc1MzAgV1U=," +
            "QWtpcmEyMDIx," +
            "QmJveC1DNDEyRkI1Mw==," +
            "VmVyaXpvbl85NFNQWDk=," +
            "R2FsYXh5IFMyMDFiYTE=," +
            "U0tfV2lGaUdJR0EwQkVCXzIuNEc=," +
            "TG92ZUdvbGlhdGgzLTVH," +
            "RkRHNTg1Mw==," +
            "RE9DVE9STElGRV9BRE1JTg==," +
            "Qm94XzYzMzM0," +
            "Q2hhcmxlcw==," +
            "VGVsaWEtNDRBNjA1," +
            "V2lmaSB2YW4gTWFyaWFubmU=," +
            "Q2hhcmxlcyA=," +
            "QVNVUw==," +
            "VEFEQUFNXzdKTDdNMkc=," +
            "U0tZRklRTFo=," +
            "T1JCSTU3," +
            "VmVyaXpvbl82WllLSFE=," +
            "TUlXSUZJXzdzcDY=," +
            "VGVsZW5ldDg1NTk2NDI=," +
            "dGVsZW5ldC03QkVCMzgy," +
            "Q29tbXVuaXR5RmlicmUxMEdiXzdCQTQ2," +
            "U0tfV2lGaUdJR0E3M0Ew," +
            "U2lnYWxvdg==," +
            "a3NrIHN0ZWVuYnJ1Z2dl," +
            "Vm9kYWZvbmUyLjRHSHotQTMzNTc0ODg=," +
            "Vm9kYWZvbmUtQTUwMjMwNDM3," +
            "QWlycG9ydCBCdXJn," +
            "VlRSLTM3MzE1NTg=," +
            "V2lmaW5ldHdlcmsgdmFuIGphY2NvIDIgYm92ZW4=," +
            "TGl2ZWJveDYtRDUzRg==," +
            "SG9tZVN3ZWV0SG9tZQ==," +
            "VE1OTC0xNjY3MjE=," +
            "YWNtZ2IxQHlhaG9vLmVz," +
            "VFAtTGlua183MzdD," +
            "ZGxpbmtfRFdSLTkzMl9DRDNG," +
            "WmlnZ29DNTMyNDUx," +
            "QmpvcmttbyBHYWFyZA==," +
            "aXA=," +
            "TWlGaWJyYS05NkUy," +
            "VE1PQklMRS02QUM5," +
            "SmFubmVh," +
            "Q2FybTEyNjk1," +
            "TUFSQVRIT04=," +
            "Sm9zZSB3aWZp," +
            "R3JhbmRtYVgy," +
            "VGhlTWlnaHR5T0FL," +
            "RnVubnkgcGluZXM=," +
            "R3JhbmRtYXNYMg==," +
            "TkVUR0VBUjg5," +
            "S29uc3RhbnRpbm9zIFBhcnRuZXJz," +
            "TVROXzIuNEdfMzUyMUYz," +
            "U3BlY3RydW1TZXR1cC00Nw==," +
            "TWF0bG9ja25ldDIuNA==," +
            "SU5GSU5JVFVNNTM2NF8yLjQ=," +
            "TkVUR0VBUjkz," +
            "TkVUR0VBUjQwLTVH," +
            "U25vd0Rlc2VydFByb2R1Y3Rpb25zXzIuNEc=," +
            "TkVUR0VBUjIz," +
            "RDIxMzBE," +
            "RDIxMzBD," +
            "V2FybmluZyEhIDop," +
            "U2xpbmdlcnRvdXc=," +
            "Q1BFUlJFQVVXSUZJ," +
            "UG9uQmFv," +
            "U0lOR1RFTC1FRTdC," +
            "TGl2ZWJveC00RjBD," +
            "QUs0MzI=," +
            "Tk9LSUEtNDRBMQ==," +
            "QVNVUzUwMw==," +
            "bm9tYWRzZW91bA==," +
            "R2FyZmllbGQ=," +
            "U0tZTU0zVlI=," +
            "SVpaSS01Ry1BNEY4," +
            "bm9tYWRzZW91bDIuNEc=," +
            "bS5rZW1lbmFkZUBiYmhtYWlsLm5s," +
            "VStOZXRBN0Y5," +
            "TW9iaWxlIFdpRmktOE10RnFW," +
            "U0tfV2lGaUdJR0E3M0EwXzIuNEc=," +
            "Q2Ftby1OYXRpb24gKg==," +
            "TkVUR0VBUjAxLTVH," +
            "TUlUTE9DQUw=," +
            "TWFnZW50YVdMQU4tV1JDSA==," +
            "U0lN," +
            "ZnVubnlwaW5lcw==," +
            "Y2FzaXRh," +
            "TW9ua2V5X01hZ2lj," +
            "VE1PQklMRS1BNkVG," +
            "VEVMVVMxMTM3," +
            "TkVUR0VBUjc0," +
            "TE9MTzE=," +
            "TkVUR0VBUjkzLTVH," +
            "WmhvbmVfOUFENA==," +
            "SFVBV0VJX0U1NTc3XzM0MjA=," +
            "SE9NRQ==," +
            "OTg3Q0Ix," +
            "RnJvbnRpZXI4Mjcy," +
            "OTg3Q0I5," +
            "Rmlvcy14M1ROWA==," +
            "VFAtTElOS18yNkZE," +
            "T1JCSTIw," +
            "U1Nob21l," +
            "S1RfR2lHQV9CMTFG," +
            "UlVUOTUwXzFGREE=," +
            "Rmlvcy1HclM0Ri1HdWVzdA==," +
            "U01CUi0yRw==," +
            "UmVkbWkgOUE=," +
            "V2lyZWxlc3NOZXQ=," +
            "ZXRvaWxlbmFpbHM=," +
            "RElHSUZJQlJBLTA2RDg=," +
            "RlJJVFohQm94IDc1MzAgWU8=," +
            "SDE1OC0zODFfNDY0QQ==," +
            "TVc0MFZfNzBGRQ==," +
            "VFBMSU5LLUFHU00=," +
            "TWlsYW5vIFJlc3RhdXJhbnQ=," +
            "VFAtTElOS19DNjlGQjQ=," +
            "dmFuTWFyaXM=," +
            "V2lmaW5ldHdlcmsgdmFuIEtlZXM=," +
            "TUlXSUZJX3VjeXk=," +
            "SEFSSUNI," +
            "Rmpvc2thbWVyYQ==," +
            "RXNwaWdhcw==," +
            "RlJJVFohQm94IDU0OTAgR1k=," +
            "RklHVUVST0EgWSBDSUEgTFREQQ==," +
            "S1RfR2lHQV8yR19XYXZlMl9BMUVG," +
            "dGVsZW5ldC1GQ0Y4Mw==," +
            "a2Fzc2l0YQ==," +
            "ZGxpbms=," +
            "S1RfR2lHQV81R19XYXZlMl9BMUVG," +
            "ZGtsaW5rc3lz," +
            "Qm9zSG9tZQ==," +
            "TW9lcmRpams=," +
            "RlJJVFohQm94IDY2NjAgQ2FibGUgSkI=," +
            "RlJJVFohQm94IEdhc3R6dWdhbmc=," +
            "T3ds," +
            "TWF1cmk0MTI=," +
            "UGFrbw==," +
            "WmVnZXJz," +
            "RElHSUZJQlJBLVBMVVMtRkQwOA==," +
            "UGFrby1HYXN0," +
            "VXNlaW4=," +
            "RlJJVFohQm94IDc1OTAgUkw=," +
            "QWx0aWJveDYxMzYwOV9FWFQ=," +
            "TWFpc29uIHdpZmk=," +
            "RElHSV82YWQ5YzA=," +
            "c2lsdmlfY29waWx1MTlAeWFob28uY29t," +
            "RkFTVFdFQi04MUY5QjA=," +
            "VlRSLTQ0NjI5MzQ=," +
            "S1BONUE2RDg2," +
            "WmlnZ29BMUY2ODZG," +
            "WmlnZ28wOTcyNDg1," +
            "dEhlRGhBVFRz," +
            "VmlsbGFycm9lbA==," +
            "Vk03OTY0NTkz," +
            "SG9tZQ==," +
            "bWFhbG91bGE=," +
            "VlRSLTUwMTgyNjE=," +
            "SE9NRS05QUY0LTU=," +
            "RGlnaWNlbF9XaUZpX3RDSDI=," +
            "U3BlY3RydW1TZXR1cC01OQ==," +
            "RVRSQUhPTUU=," +
            "VFRIQVVTLTIuNA==," +
            "U0tfV2lGaUdJR0E4NzEy," +
            "REFOREFOLg==," +
            "SEg3MVZNX0MyNjNfNUc=," +
            "TWFybG9lc0plbG1lcg==," +
            "TGl2ZWJveC04QzNDXzVHSHo=," +
            "RElHSUZJQlJBLUZEMDg=," +
            "V2lGaSBuZXR3ZXJrIHZhbiBhMTJtYXRqZTIxYQ==," +
            "dWxsdTIuNA==," +
            "Wndhbmlra2Vu," +
            "UEFDSEkx," +
            "WmlnZ283NzE4NTI0," +
            "U2VyaWVzIG9mIFR1YmVz," +
            "VEFMS1RBTEs0REY5NUQ=," +
            "VGhlVnVz," +
            "R2ludGVyLkhvbWU=," +
            "Um9zc2luaQ==," +
            "R28tR28gR2FkZ2V0LCBXSUZJIQ==," +
            "SHVzc2VpbkBSb2Vz," +
            "Qk8kJA==," +
            "c3VtbWVyIERyeQ==," +
            "S1RfR2lHQV81R19CMTFG," +
            "TUVaQSBDQU5ERUxB," +
            "R28gQ29mZmVlIERyLiBTZXplZnJlZG8=," +
            "MjgwRUE4," +
            "Q1dDLTU0NTQ0Nzk=," +
            "MjgwRUE3," +
            "Q29sbGllXzVH," +
            "WmlnZ29EQzk1MjQx," +
            "SFVBV0VJLUNUMUpMNQ==," +
            "VFAtTGluaw==," +
            "Wnl4ZWwxNDMxOQ==," +
            "UmVkIFZvbGtzd2FnZW4=," +
            "Y3JhenkgYmlyZCBsYWR5," +
            "U1RDLTRH," +
            "TkVUR0VBUjQ3," +
            "Qk8kJCBL," +
            "RElHSV9lMzBkMjI=," +
            "bzItV0xBTjA0," +
            "QnJ5bmRhbGVAWmlnZ28yLDQgR0h6," +
            "U2NvdHQtMTg=," +
            "WmlnZ28zNDk2NjMy," +
            "VmFuaSBIb21l," +
            "Znpjbw==," +
            "QVNVU181Rw==," +
            "Vk9PLUJSRTVOU1A=," +
            "RnJvbnRpZXIwODE2XzVHXzJHRVhU," +
            "R2FsbGVyeQ==," +
            "Q2xhcm8tNDBiOA==," +
            "U2FiYXRpZXI=," +
            "TXlTcGVjdHJ1bVdpRmkzYy0yRw==," +
            "VG90YWxwbGF5LTM1OUQ=," +
            "TXlBbHRpY2UgZmZiMDli," +
            "SE9NRTM5N181R0ha," +
            "c3R1ZmYyNA==," +
            "REJ1bnM=," +
            "SE9NRTM5Nw==," +
            "MldJUkUwMTY=," +
            "QzEtTGl0ZV82QkIxMDg=," +
            "QkVDNEFB," +
            "QnVkZGhhIEJlZQ==," +
            "QUNJ," +
            "U0hBVy0zOEY4LTI0," +
            "QWxhaXNoYS4=," +
            "SG9tZTEwMDA=," +
            "U3BlY3RydW1TZXR1cC04OQ==," +
            "QVRUSDRZd0pXYQ==," +
            "VFAtTGlua183RDdB," +
            "Rmlvcy1ONU56Zg==," +
            "dGhhbmtzbmV0," +
            "S2Vubnk=," +
            "S2lsb0VjaG9TZXZlbg==," +
            "QVRUSkJCVDRUQQ==," +
            "U0tfV2lGaUdJR0FDNkU4XzIuNEc=," +
            "TWFuYXlhbmlrYWw=," +
            "QVNQQU4=," +
            "T3B0dXMtNEctRTU1NzctRkI1RQ==," +
            "RGltb25hdg==," +
            "SGVsaWE=," +
            "R2F0aGlrIFJlZGR5," +
            "RkJYX0JSWUNaTUFOX1RBUkVM," +
            "S1BIT01FMi40Rw==," +
            "RHV5IFR1eWVu," +
            "QVRUZDRZVVB0NQ==," +
            "U2t5IG1vYmlsZXMgNWc=," +
            "WmlnZ29BNzZFQTU0," +
            "U2t5IG1vYmlsZXM=," +
            "QWxjYXRlbCBMaW5rWm9uZV85RTE1," +
            "VFAtTGlua180RDE4," +
            "R01BQzE=," +
            "Vm9kYWZvbmUtQzcxMw==," +
            "SHl0dGVuZXR0," +
            "TkVUR0VBUg==," +
            "SDY1NDUwNTcgNUc=," +
            "TG93aURCOTYtIDIsNCBHSHo=," +
            "U0tfV2lGaUdJR0FCNjc3," +
            "WmlnZ29BMkFFN0Y5," +
            "WmlnZ282MjE1Mjkw," +
            "Q29qb2Nhcmlp," +
            "RlJJVFohQm94IDc1MzAgWkQ=," +
            "aG9lbmRpZXA=," +
            "ZmF6ZW5kYQ==," +
            "Y29qb2Nhcmlp," +
            "VmVyaXpvbl80WkZUNlBfSW9U," +
            "WmlnZ28zNjUyOTQ0," +
            "YXNzbWVqcw==," +
            "TUVPLTI1QUQ5MA==," +
            "UlBB," +
            "V2F6YWFhYWEh," +
            "emlnZ28tYXAtNzY3MThkNA==," +
            "RG9rdGVy," +
            "R2V0LTg0Mzg4Mw==," +
            "RGlzY29yZGlhMjM=," +
            "RmFtaWxsZVpvZGE=," +
            "WmlnZ29DQjlDOUZF," +
            "VE1OTC04RERDRjE=," +
            "aWNlLm5ldC02QUIyOTc=," +
            "TkVUR0VBUjAx," +
            "TmFjaG8gV2lGaQ==," +
            "VE1OTC1BQ0ExRDE=," +
            "VEhPLTI=," +
            "dGVsZW5ldC01ODcxMDk4," +
            "U0ZSX0QxNEY=," +
            "T3B0dXNfQjYyOF9CNjND," +
            "VGpvcmJlbkxlbmFfMi40Rw==," +
            "Q2hyaXNhbmRzaW1iYQ==," +
            "SDM2OUFGNjk2NkY=," +
            "U2t5IG1vYmlsZXMg," +
            "WmlnZ283RERGNTRC," +
            "QVRUdzZSakVhMg==," +
            "TWFvcg==," +
            "SDY1NDUwNTcgNEc=," +
            "SU5GSU5JVFk=," +
            "TXlBbHRpY2UgZTY2NjI4," +
            "aVBob25l," +
            "Q09OLUFQ," +
            "UmVsIFNtYXJ0SG9tZQ==," +
            "TkVUR0VBUjgz," +
            "dGVsZW5ldC0yMjU0RjY5," +
            "RlJJVFohQm94IDY2NjAgQ2FibGUgU1Q=," +
            "U3VydmVpbGxhbmNlVmFuIzU=," +
            "V0xBTl8yODE4," +
            "aWlOZXQ1NDg2QTUtNUdfMi40Rw==," +
            "TWlsbw==," +
            "SG9udWEgS2FpIFJlc29ydCAmIFNwYQ==," +
            "TG9zRnVtZXRhcw==," +
            "S2lsb0VjaG9TZXZlbjU=," +
            "S1RfR2lHQV81R19XYXZlMl8yMUE2," +
            "VFAtTGlua181MDcw," +
            "S1RfR2lHQV8yR19XYXZlMl8yMUE2," +
            "Q2Fib3Zpc2FvLUFDRTA=," +
            "VEVMVVNFQkI1," +
            "NzUwOEtQ," +
            "VFAtTGlua19EMEVD," +
            "VElNLTE5Nzk2OTQ1," +
            "RmVsbGUgQmVhdSBNSw==," +
            "SVpaSS1EMDc0," +
            "SFVBV0VJLUIzMTUtQjgwRg==," +
            "dGVsZW5ldC1qYWFr," +
            "VXB0aW1l," +
            "R2VzLldpRmk=," +
            "RU9MTyAtIEZSSVRaIUJveCBPUg==," +
            "UFI=," +
            "RlJJVFohQm94IDU1MzAgRVY=," +
            "U0tfV2lGaUdJR0FEQ0Qy," +
            "UGFyb09mZmljZQ==," +
            "U09ITw==," +
            "SXJhbmNlbGwtVEYtaTYwLTcyNkY=," +
            "TWFyYyBGcml0emJveA==," +
            "VFAtTGlua18yNDg0," +
            "TUMzMTE1," +
            "Q09UVS0yNA==," +
            "S2F0amE=," +
            "S2FyYW4tNUc=," +
            "RlRUSF9PWjI0Nzg=," +
            "WmlnZ281NEU1MThB," +
            "bXlMR05ldA==," +
            "WmlnZ28tZ2FzdDg1MzA3NzA=," +
            "TXlTcGVjdHJ1bVdpRmk0MC0yRw==," +
            "RkFNSUxJQU1PUkVOSVJJT1M=," +
            "a25pZmZpLWJveA==," +
            "U3dlZXRGYXJtMg==," +
            "R29sb25kcmluYXMgNUc=," +
            "7L+g7YKk64Sk," +
            "R29sb25kcmluYXMgMi40," +
            "S2VlbmV0aWMtMTQ1Mg==," +
            "QmJveC1XaWxs," +
            "QmV0cmV1dGVzLVRyaW5rZW4=," +
            "ZWljaGVuYXVlcmJ1ZXJv," +
            "SFVBV0VJLTIuNEctZnQ3Sw==," +
            "bWVuYWhvbWUy," +
            "Vm9kYWZvbmVXSUZJLUNhc2FfRVhU," +
            "Q2FzZXkyLjQ=," +
            "S2VlbmV0aWMtOTIwMg==," +
            "Qk9VVElRVUU=," +
            "WmlnZ28xNjE2MDQw," +
            "RXR1ZA==," +
            "TU9WSVNUQVJfUExVU180NTcw," +
            "RElHSS0gbnUgZSBmcmVl," +
            "Q0FTQVdJRkk=," +
            "dGVsZW5ldC1ERENBNQ==," +
            "QmJveC1EMkI2NUREMQ==," +
            "T1JCSTcw," +
            "RGlnaWJveC03Nzc2," +
            "cGxlYXNlIHlvdXI=," +
            "U3BlY3RydW1TZXR1cC0wMA==," +
            "U3BlY3RydW1TZXR1cC05MA==," +
            "dGluZ3Rpbmc=," +
            "VStOZXQ1RjYz," +
            "V0ZU," +
            "dGluZ0V4dGVuZA==," +
            "UkU=," +
            "d2NzajE=," +
            "TGFib3JhbnRl," +
            "TG92ZVNoYWNrUlY=," +
            "8J+HqfCfh7RUaXRvLUFuZ2VsZXMtV2lGaQ==," +
            "Rm9ydHJlc3Mgb2YgU29saXR1ZGUg," +
            "Rm9ydHJlc3NPZlNvbGl0dWRl," +
            "VlBsYWNlXzlBYQ==," +
            "TUVSQ1VSWV9GMTQ4ODg4," +
            "RU9MTyAtIEZSSVRaIUJveCBPUl9FWFQ=," +
            "MTcwMu2YuA==," +
            "d2Vnb3RpdDg4ODc=," +
            "Q09UVQ==," +
            "dGFldzI1Mzk=," +
            "U0tfV2lGaUdJR0FEQ0QyXzIuNEc=," +
            "S1M=," +
            "RlJJVFohQm94IDc1MzAgVUY=," +
            "S2FyYW4=," +
            "U0hBVy0zOEY4," +
            "Tm90IFlvdXIgV0lGSQ==," +
            "SEFSTUVO," +
            "VGVsaWEtOTAyQjI1LUdyZWl0YXM=," +
            "U3dlZXRGYXJtMQ==," +
            "ZGV2MW5ldA==," +
            "V2lGaS0yLjQtRkVBMA==," +
            "VGVsaWEtOTAyQjI1LUdyZWl0YXNfMkc=," +
            "RlJJVFohQm94IDc1OTAgSks=," +
            "VE1PQklMRS1CQUY0," +
            "RUUtSHViLVQ0a0o=," +
            "Q2FzZXktV2lGaQ==," +
            "TWFyZ2l0aHVzZQ==," +
            "Vm9kYWZvbmUtQTgyMDE4ODU1," +
            "QWx0aWJveDUzMjE0Nw==," +
            "TkVUR0VBUjEz," +
            "S0lORVRJQ19GNUI4NDA=," +
            "SCZIIGJyby4uLg==," +
            "Q2FzYSBMUA==," +
            "Rm9ydHJlc3Mgb2YgU29saXR1ZGU=," +
            "T1JCSTc3Nw==," +
            "aWlOZXQ1NDg2QTUtNUc=," +
            "REFORyBLSE9B," +
            "Vk9EQUZPTkVfV0lGSV8xMDg=," +
            "ZmFzdA==," +
            "WmFpbi1GaQ==," +
            "TkVESUNIIDIuNCBHSHo=," +
            "TU9WSVNUQVJfQTE1MA==," +
            "UEFSSVRFTF9XSUZJ," +
            "TW9uYSBvZyBKYW4gT3ZlIHNpdHQ=," +
            "VVJRVUhBUlQgVFYgUk9PTQ==," +
            "RGVjb18wMEM0," +
            "TWFycw==," +
            "S1RfR2lHQV81R19BNDA3," +
            "QlRCLU5QQ0dSTQ==," +
            "TGl2ZWJveC00NGRj," +
            "RGlnaWthbGE=," +
            "V0xBTi0zNjkzMDI=," +
            "SmVmZXJzb24gTWVuZG96YQ==," +
            "TGlzZXMgaVBob25lIDEz," +
            "SG9yc2JhZWtrZW4gMjMgU3VydmVpbGxhbmNl," +
            "SDM2OUE1NzQxOEM=," +
            "RGFydGggVmFkZXIgMi40IEdoeg==," +
            "WmlnZ285MDUwOTE0," +
            "V2lubmVyczIwMTA=," +
            "TkVUR0VBUjYwX0VYVA==," +
            "SmFtZXMgQXdlc29tZSBOZXQ=," +
            "VmlkacSH," +
            "TGl2ZWJveC1ENDUw," +
            "WmlnZ28xMDg5MjE3," +
            "b2xsZWhfR2lHQV9XaUZpX0RFQkQ=," +
            "V2lGaS0yLjQtNzhEOQ==," +
            "TWF0ZQ==," +
            "b2xsZWhfV2lGaV9ERUJE," +
            "WDIxLTIuNEctM0UxNjMx," +
            "VFAtTGlua19FeHRlbmRlcg==," +
            "QWlyVGllc19BaXI0OTMwX0dVRVNU," +
            "TDEwTkgzQVJU," +
            "S1BOQzlCMTU2," +
            "TElCLTQ4MjAwNzA=," +
            "V2lGaSBUaHVpcw==," +
            "RmFtaWx5IER1bmFudA==," +
            "RnJlZWJveC01QzM2MEQ=," +
            "dW5hbGJhc3JpQGhvdG1haWwuY29t," +
            "Wnl4ZWxfNTQ0RA==," +
            "RHlncmE=," +
            "U3BlY3RydW1TZXR1cC0yQg==," +
            "TEVFIE5FVF9FWFQ=," +
            "U3RlZW5TZWRpamtpZV8yLjRH," +
            "R2VpbGVNZWxhbmV5," +
            "Q29tZXNlci1NYXJ6aQ==," +
            "TEVFIE5FVA==," +
            "TkVUR0VBUjI2LTVH," +
            "QVRUWHF3WVZrbC01Rw==," +
            "TXlTcGVjdHJ1bVdpRmkyNy0yR18yR0VYVA==," +
            "VmlydHVhbA==," +
            "U2hhbm5vbg==," +
            "TWF0bG9ja25ldA==," +
            "U3BlY3RydW1TZXR1cC1EOQ==," +
            "VlRSLTcyMzYyMDc=," +
            "amFvYmVhbmluaQ==," +
            "c2t5TGlmZV9XaUZpXzJHXzhFMTE=," +
            "U21pdGhIb21lMjQ=," +
            "VGVsY2VsLVpURS1NRjI5M04tOEI3MA==," +
            "Y21pbnZlcnNpb25lc2NjcEBnbWFpbC5jb20=," +
            "Sm9uYXRoYW4=," +
            "TW9zZXPigJlzIFdpLUZpIE5ldHdvcms=," +
            "U0tfV2lGaUdJR0E2QkYwXzIuNEc=," +
            "SFVBV0VJIFA0MA==," +
            "dGNqdG5ldA==," +
            "VGlwcHl0b2Vz," +
            "RWwgdmFsbGUgMi41," +
            "U0tfV2lGaUdJR0FENjY0," +
            "V2lyZWxlc3NfTl9DRjNC," +
            "QWFyb24=," +
            "QmVhckJhcl9EcmVhbU1hY2hpbmU=," +
            "S3Jpc3R5bmE=," +
            "TGVobWFubg==," +
            "V2lmaSBBdXRvY2Ega2ltdQ==," +
            "RlJJVFohQm94IDc1OTAgVlk=," +
            "cGljazM=," +
            "SDM2OE40NzBGMTY=," +
            "a2l0Y2hlbg==," +
            "64uk66Gx64Sk7J28," +
            "U0tfV2lGaUdJR0FENjY0XzIuNEc=," +
            "TWluV2lmaQ==," +
            "aWNlLm5ldC03RkVGMEI=," +
            "TUlXSUZJX0ZKcnA=," +
            "Q2hhY2h1IEhvdXNpbmcgU2hvcA==," +
            "QmFyYmVxdWUuY2FtZXJhQGdtYWlsLmNvbQ==," +
            "S1RfR2lHQV8yR19CMTY4," +
            "bmF0Y29tcG8=," +
            "SmFLbyBNT0JJTEU=," +
            "RGFydGggVmFkZXIgNS44IEdoeg==," +
            "TkVUR0VBUjYw," +
            "WmlnZ280MDQ0OTE2," +
            "VGFza21hc3Rlcg==," +
            "SDM2OUE1QTMyNTI=," +
            "WmlnZ281RUQ1RDg1," +
            "VHdpbmtsZQ==," +
            "THVzdV81R0h6," +
            "ZGxpbmstOTU2TS0yLjRHLTU2YTY=," +
            "TkVUR0VBUjI2," +
            "RkJJU3VydmVpbGxhbmNldmFuNzE=," +
            "VFAtTGluayBKQk4gIEI=," +
            "V0lGSUVORUxCT1NRVUU=," +
            "TmFzaGxhIE1hcnRpbmV6";

    /**
     * 返回二进制数的第index位的值
     *
     * @param num   要获取二进制值的数
     * @param index 右边第一位为0，第二位为1，依次类推
     */
    public static int getBData(int num, int index) {
        if (0 > num) {
            return -1;
        }
        return (num & (0x1 << index)) >> index;
    }


    public static long getSecondsByDate(String date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            return simpleDateFormat.parse(date).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static double calculateAngle(int x1, int y1, int x2, int y2) {
        // 计算斜率
        double dx = x2 - x1;
        double dy = y2 - y1;
        double slope = dy / dx;

        // 计算夹角
        double angle = Math.toDegrees(Math.atan2(dy, dx));

        return angle;
    }


    /**
     * @param strBinary 二进制字符串
     * @return 十进制长整型
     */
    public static long BinaryToDecimal(String strBinary) {
        long result = 0;
        for (int i = strBinary.length() - 1; i >= 0; i--) {
            if (strBinary.charAt(i) == '1') {
                long temp = 1;
                for (int j = 0; j < strBinary.length() - i - 1; j++) {
                    temp *= 2;
                }
                result += temp;
            }
        }
        return result;
    }

    private static long transformLong(int[] times) {
        if (null == times || times.length == 0) {
            return 0;
        }
        int total = 1439;
        int[] locations = new int[times.length];
        for (int i = 0; i < times.length / 2; i++) {
            locations[i << 1] = (total - 1) - (times[(i << 1) + 1] / 1 - 1);
            ;//(total-1) - (times[(i << 1) + 1] / 30 - 1);
            locations[(i << 1) + 1] = (total - 1) - (times[i << 1] / 1);//(total-1) - (times[i << 1] / 30);
        }
        System.out.println("transformLong locations:" + Arrays.toString(locations));
        StringBuilder cycleTime = new StringBuilder();
        for (int i = 0; i < total; i++) {
            boolean in = false;
            for (int j = 0; j < locations.length / 2; j++) {
                if (i >= locations[j << 1] && i <= locations[(j << 1) + 1]) {
                    in = true;
                    cycleTime.append("1");
                    break;
                }
            }
            if (!in) {
                cycleTime.append("0");
            }
        }
        System.out.println("transformLong times:" + Arrays.toString(times));
        System.out.println("transformLong cycleTime:" + cycleTime.toString());
        return BinaryToDecimal(cycleTime.toString());
    }

    /**
     * 返回日期时间戳  毫秒
     *
     * @param date
     * @param patten
     * @return
     */
    public static long getDayTime(String date, String patten) {
        long time = (new SimpleDateFormat(patten)).parse(date, new ParsePosition(0)).getTime();
        return time;
    }

    /**
     * 秒转时间字符串
     *
     * @param seconds
     * @param pattern
     * @return
     */
    public static String getDateBySeconds(long seconds, String pattern) {
        Date date = new Date(seconds * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(date);
    }



    /**
     * 根据日期格式和time(毫秒)，返回日期/时间字符串
     *
     * @param dateFormat e.g. yyyy-MM-dd ; yyyyMMdd HH:mm:ss ; etc.
     * @param timeMillis 时间对应的毫秒数
     * @return 日期/时间的字符串
     */
    public static String getDateString(String dateFormat, long timeMillis) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
             formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            // 添加调试：打印实际使用的时区
            // 添加详细的调试信息
            System.out.println("=== 方法内部调试 ===");
            System.out.println("传入的 timeMillis: " + timeMillis);
//            System.out.println("Formatter使用的时区: " + formatter.getTimeZone().getID());
            System.out.println("Formatter时区偏移: " + formatter.getTimeZone().getRawOffset());
            Date date = new Date(timeMillis);
//            System.out.println("Date对象时间: " + date.getTime());

            String result = formatter.format(date);
            System.out.println("格式化结果: " + result);
            System.out.println("=== 调试结束 ===\n");
            return formatter.format(date);
        } catch (Exception ex) {
            //Log.e(TAG, "getDateString(String,long) method exception:" + ex.getMessage());
        }
        return "";
    }



    public static long findMax(long[] arr) {
        long max = arr[0]; // 初始化最大值为数组的第一个元素
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // 更新最大值
            }
        }
        return max;
    }

    public static long findMin(long[] arr) {
        long min = arr[0]; // 初始化最小值为数组的第一个元素
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i]; // 更新最小值
            }
        }
        return min;
    }


    private static ArrayList<String> getMergePeriodTimes(ArrayList<String> dayTimes) {
        ArrayList<String> result = new ArrayList<>();
        if (dayTimes != null && dayTimes.size() > 0) {
            for (int i = 0; i < dayTimes.size() / 2; i++) {
                String startTime = dayTimes.get(i * 2);
                String endTime = dayTimes.get(i * 2 + 1);
                if (result.size() > 0) {
                    for (int j = 0; j < result.size() / 2; j++) {
                        String rStartTime = result.get(j * 2);
                        String rEndTime = result.get(j * 2 + 1);
                        long curMin = getSecondsByDate(startTime, "HH:mm");
                        long curMax = getSecondsByDate(endTime, "HH:mm");
                        long rMin = getSecondsByDate(rStartTime, "HH:mm");
                        long rMax = getSecondsByDate(rEndTime, "HH:mm");
                        if (curMin > rMax) {
                            result.add(startTime);
                            result.add(endTime);
                            if (result.size() == dayTimes.size()) {
                                break;
                            }
                        } else {
                            //需要找最大最小值
                            long[] data = new long[]{curMin, curMax, rMin, rMax};
                            long min = findMin(data);
                            long max = findMax(data);
                            String sTime = getDateBySeconds(min, "HH:mm");
                            String eTime = getDateBySeconds(max, "HH:mm");
                            if (max == 86400) {
                                eTime = "24:00";
                            }

                            result.set(j * 2, sTime);
                            result.set(j * 2 + 1, eTime);
                        }
                    }
                } else {
                    result.add(startTime);
                    result.add(endTime);
                }
            }
        }
        return result;
    }

    /**
     * 时间字符串转秒数
     *
     * @param date
     * @param pattern
     * @return 秒时间戳
     */
    public static long getLongByDate(String date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            return simpleDateFormat.parse(date).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 将 时:分 格式 的时间转化为秒数
     */
    public static int timeToSecond(String time) {
        int second = 0;
        if (time.contains(":") && time.length() == 5) {//00:00
            int hour = Integer.parseInt(time.substring(0, 2)) * 3600;
            int min = Integer.parseInt(time.substring(3)) * 60;
            second = hour + min;
        } else if (time.contains(":") && time.length() == 8) {//00:00:00
            int hour = Integer.parseInt(time.substring(0, 2)) * 3600;
            int min = Integer.parseInt(time.substring(3, 5)) * 60;
            int sec = Integer.parseInt(time.substring(6));
            second = hour + min + sec;
        }
        return second;
    }

    /**
     * 返回时长字符串（格式 00:00 或 00:00:00）
     * @param time 毫秒
     * @return 格式化后的时长字符串
     */
    public static String getVideoDur(long time) {
        long totalSeconds = time / 1000;
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;
        if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d", minutes, seconds);
        }
    }

    private static  Map<String, Integer> requestMap = new HashMap<>();

    /**
     * 将小端序（Little-Endian）的整数值转换为IP地址字符串
     *
     * @param littleEndianInt 小端序的整数值（如 17344704）
     * @return IP地址字符串（如 "192.192.8.1"）
     */
    public static String littleEndianIntToIp(int littleEndianValue) {

        // 将int转换为4字节数组（小端序）
//        byte[] bytes = ByteBuffer.allocate(4)
//                .order(ByteOrder.LITTLE_ENDIAN)
//                .putInt(littleEndianInt)
//                .array();
//
//        // 提取每个字节并转换为无符号整数（0~255）
//        int octet1 = bytes[0] & 0xFF;
//        int octet2 = bytes[1] & 0xFF;
//        int octet3 = bytes[2] & 0xFF;
//        int octet4 = bytes[3] & 0xFF;

//        int littleEndianValue = 302557376;

        // 直接按小端解释：交换字节顺序
        int bigEndianValue = Integer.reverseBytes(littleEndianValue);

        // 转为IP
        String ip = String.format("%d.%d.%d.%d",
                (bigEndianValue >> 24) & 0xFF,
                (bigEndianValue >> 16) & 0xFF,
                (bigEndianValue >> 8) & 0xFF,
                bigEndianValue & 0xFF
        );


        // 拼接为IP地址字符串
        return ip;
    }

    public static void main(String[] args) {
//         String date=  getDateString("yyyy-MM-dd HH:mm:ss.SSS",1757872614839L);
//         System.out.println(" date:"+date+" 时区："+TimeZone.getDefault());
//
//        System.out.println("当前默认时区: " + TimeZone.getDefault());
//        System.out.println("系统时区: " + TimeZone.getTimeZone("Asia/Shanghai")); // 对比一下


//        System.out.println(littleEndianIntToIp(302557376));





//        Integer pro = Integer.valueOf("0.0");
//        System.out.println(pro);

//        String dur=  getVideoDur(3661*1000);
//        System.out.println("dur:"+dur);
//
//        getSecondsByDate("","");


//        System.out.println(timeToSecond("08:59:01"));
//        System.out.println(getSecondsByDate("08:59:01","HH:mm:ss"));


//progress:116039 total:120000
//        int p=120000;
//       int t=120000;
//
//        // 计算比例
//        double ratio = (double) p / t * 100;
//
//        // 使用 DecimalFormat 格式化为两位小数
//        DecimalFormat df = new DecimalFormat("0");
//        String formattedRatio = df.format(ratio);
//
//        // 输出比例
//        System.out.println("p 占 t 的比例: " + formattedRatio + "%" +" rate:"+ratio);
//       long  mTimeValue=7145;
//        mTimeValue -= mTimeValue % 60;
//        System.out.println("mTimeValue:"+mTimeValue);
//
//
//
//       long i=47231;
//       float a=i/(12f*60);
//        System.out.println("a="+a);


//        ArrayList<String> data=new ArrayList<>();
//        for (int i = 0; i <356 ; i++) {
//            data.add(i+"");
//        }
//
//        HashMap<Integer,ArrayList<String>> map=new HashMap<>();
//        int j=0;
//        for (int i = 0; i < data.size(); i++) {
//            if(i%100==0){
//                j++;
//            }
//            if(map.get(j)==null){
//                ArrayList<String> cData=new ArrayList<>();
//                cData.add(data.get(i));
//                map.put(j,cData);
//            }else{
//                ArrayList<String> cData=   map.get(j);
//                cData.add(data.get(i));
//            }
//        }
//
//        System.out.println("总分批数量："+j);
//        // 使用for-each循环遍历Map的键值对
//        for (Map.Entry<Integer,ArrayList<String>> entry : map.entrySet()) {
//            Integer key = entry.getKey();
//            ArrayList<String> value = entry.getValue();
//            System.out.println(key );
//        }
//
//        System.out.println("map:"+JSON.toJSONString(map));


//        float velocityX = 300 / 480 ;//Math.abs(300 / 480)
//        System.out.println(velocityX);

//        System.out.println(""+secForTime(360*12+61));


//        SimpleDateFormat  mFormatter = new SimpleDateFormat("MM.dd", Locale.US);
//        System.out.println(mFormatter.format(new Date()));


//        String s="000000000111111110000000000000";
//        ArrayList<String> days=new ArrayList<>();
//        for (int i = 0; i <s.length() ; i++) {
//           String v= s.substring(i,i+1);
//           if(v.equals("1")){
//               int day=i+1;
//                String dayStr=day<10?"0"+String.valueOf(day):String.valueOf(day);
//               days.add("2024-06-"+dayStr);
//           }
//        }
//
//        System.out.println("days:"+days.toString());


//        int i=32;
//
//        for (int j = 0; j <i/2 ; j++) {
//            System.out.println("j*2:"+(j*2)+"   j<<1:"+(j<<1)+"   j:"+j);
//        }

        //[02:00, 00:00, 12:20, 20:00, 22:00, 00:00]
//
//        ArrayList<String> s=new ArrayList<>();
//        s.add("02:00");
//        s.add("00:00");
//        s.add("12:20");
//        s.add("20:00");
//        s.add("22:00");
//        s.add("00:00");
//
//        System.out.println("pre s="+s.toString());
//        s=getMergePeriodTimes(s);
//
//        System.out.println("end s="+s.toString());
//
//        System.out.println("getDayTime:"+getSecondsByDate("00:00","HH:mm"));
//
//        System.out.println("getDayTime:"+getDateBySeconds(86400,"HH:mm"));
//
//
//
//        ArrayList<String> mPeriods = new ArrayList<>(Collections.nCopies(48, "00:00"));
//
//        System.out.println("mPeriods:"+mPeriods.toString());
//
//       mPeriods= transformAlertPlanTime(140737488355324L);
//
//        System.out.println("mPeriods str:"+mPeriods.toString());
//
//        long s=transformLong(new int[]{63,1439});
//
//        System.out.println("mPeriods long:"+s);//281474976710655  140737488355327

        //["00:00","23:59"]  转 [0,0,23,59]
        //[0,0,23,59] 转

        /* ******************************************************************* */
//        ArrayList<String> times=new ArrayList<>();
//        times.add("00:00");
//        times.add("23:59");
//        times.add("12:25");
//        times.add("15:45");
//        times.add("08:10");
//        times.add("09:31");
//        System.out.println("times:"+times.toString());
//
//        int [] days=new int[times.size()*2];
//        for (int i = 0; i <times.size() ; i++) {
//            String time=times.get(i);
//            System.out.println("i<<1="+(i<<1));
//            System.out.println("i<<1+1="+((i<<1)+1));
//            days[i<<1]= Integer.valueOf(time.split(":")[0]);
//            days[(i<<1)+1]= Integer.valueOf(time.split(":")[1]);
//        }
//
//        System.out.println("times to days:"+Arrays.toString(days));

        //int [] 转 Sting []
//        ArrayList<String> periods=new ArrayList<>();
//        for (int i = 0; i < days.length/2; i++) {
//           int minutes= days[i<<1]*60+days[(i<<1)+1];
//           String hour=days[i<<1]<10?("0"+days[i<<1]):(String.valueOf(days[i<<1]));
//           String min=days[(i<<1)+1]<10?("0"+days[(i<<1)+1]):(String.valueOf(days[(i<<1)+1]));
//           periods.add(hour+":"+min);
//           System.out.println("分钟：  minutes["+i+"]:"+minutes+"  periods["+i+"]="+periods.get(i));
//        }
        /* ******************************************************************* */


//        ArrayList<String> list=new ArrayList<>();
//        list.add("liuJ");
//        list.add("liuJ1");
//        list.add("liuJ2");
//
//        list.add(0,"liuJ0");
//        list.add(0,"liuJ0x");
//
//
//        System.out.println(list.toString());

        //坐标角度计算
//        int angle= - (int)calculateAngle(50,50,0,5);
//
//        System.out.println(-calculateAngle(50,50,0,1)+" angle:"+angle);
//        if(-45<angle&&angle<45){
//            System.out.println("右边");
//        }
//        if(45<angle&&angle<135){
//            System.out.println("上边");
//        }
//        if(135<angle||angle<-135){
//            System.out.println("左边");
//        }
//        if(-135<angle&&angle<-45){
//            System.out.println("下边");
//        }


//          long seconds=38336;
//          Date date=new Date(seconds*1000);
//          SimpleDateFormat simpleDateFormat=  new SimpleDateFormat("HH:mm:ss");
//          simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//         System.out.println("时间："+simpleDateFormat.format(date));

//        System.out.println("秒数："+getSecondsByDate(simpleDateFormat.format(date),"HH:mm:ss"));


//        String value="00";
//        System.out.println(Integer.valueOf(value));


//        System.out.println(""+  getBData(1,0));
//        System.out.println(""+  getBData(0,0));


//        String mac="a0:00:00:00:07:90:1";
//        System.out.println(""+mac.split(":").length);
//        System.out.println(""+mac.split(":")[mac.split(":").length-1]);
//        System.out.println(mac.substring(0,17));

//            //base64编码
//        String originalInput = "ꚃ";
//        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
//
//            System.out.println("编码 base64:"+encodedString);
//            try {
//                System.out.println("解码 base64："+new String(Base64.getDecoder().decode("8J+mgw=="),"utf-16"));
//            } catch (UnsupportedEncodingException e) {
//                throw new RuntimeException(e);
//            }
//
//          System.out.println("-----------------------------------------------------");
//          String [] encodes=  encodeStr.split(",");
////        String [] encodes2=  encode2.split(",");
//
//            for (int i = 0; i < encodes.length; i++) {
//                String str=encodes[i];
//                try {
//                    System.out.println(new String(Base64.getDecoder().decode(str),"utf-8") +" i="+i+" str:"+str);
//                } catch (UnsupportedEncodingException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//          System.out.println("-----------------------------------------------------");
//
//
//
//           //字符转utf-16编码 方法1
//            System.out.println("stringToUnicode:"+stringToUnicode("测试"));
//            System.out.println("stringToUnicode："+stringToUnicode("Door sensor2"));
//            //字符转utf-16编码  方法2
//            System.out.println("toUnicode:"+toUnicode("测试"));
//            System.out.println("toUnicode:"+toUnicode("Door sensor2"));


//        for (int i = 1; i <10 ; i++) {
//            int position=i;
//            int left = (position - 1) << 1;// << 1左移1位
//            int right = ((position - 1) << 1) + 1;
//            System.out.println("left "+i+" ="+left);
//            System.out.println("right "+i+" ="+right);
//
//        }


//        System.out.println(cloudImageResourceFilePaths.get(1));
//
//
//        System.out.println("dafa"+"vafad"+cloudImageResourceFilePaths.get(11));
//        Float i=0.0f;
//        int f=100;
//
//        if(i<f){
//            System.out.println("i<f---------------");
//        }


//        int type= 1 |  2 | 4 | 8;
//        System.out.println(type);

//        float i=1.03333f;
//        int b=3;
//        System.out.println("i>b="+(i>b));


//        List<String> stringList=new ArrayList<String>();
//
//        stringList.add("1");
//        stringList.add("SMARTCUSTOMIZESERVICE");
//        stringList.add("SMARTCUSTOMIZESERVICE");
//        stringList.add("123456789");
//        stringList.add(null);
//        stringList.add("abcdyuidhjk");
//        stringList.add("123456789");
//
//        System.out.println(stringList.toString());
//
//        StringBuffer activityCodes = new StringBuffer();
//        for (int i = 0; i <stringList.size() ; i++) {
//            String s=stringList.get(i);
//            if(null!=s){
//                if(i!=stringList.size()-1){
//                    if(!activityCodes.toString().contains(s)){
//                        activityCodes.append(s+",");
//                    }
//                }else{
//                    if(!activityCodes.toString().contains(s)){
//                        activityCodes.append(s);
//                    }else {
//                        activityCodes.deleteCharAt(activityCodes.length()-1);
//                    }
//                }
//            }
//        }
//
//
//
//        System.out.println("activityCodes="+activityCodes.toString());


//        String uid="MUM4FCYYRPEJ7AZWZZZZKY";
//
//        System.out.println("22 位："+uid.substring(0,1));


//        String str="https://test.myfoscam.com/mobile/smart_service/mine?ipcMac=A0E2ACF694BC&ipcName=Back%20door&oemCode=&supportCvr=";
//        System.out.println(str.split("ipcMac=")[1].split("&")[0]);
//        String mac=str.split("ipcMac=")[1].split("&")[0];
//        System.out.println("mac="+mac);
//
//
//        //生成1-100随机数
//        int i = (int)(Math.random()*100+1);
//        System.out.printf("i="+i);


//        String tt="biversion:103|recordtime:2022-06-28 16:03:30|area:CN|appver:Android_3.7.1_736|network:1|evtTarget:C46E7BA34B1B:WdpPNVX3P7T3B8SJWZKIAZZZZ9Y7I|evtContent:logAddDeviceFailedConfig|AddCloud_6_appClientVersion=Android_com.foscam.foscam_3.7.1_736&appVersion=2.102.2.27&jkacsqir=21845&deviceName=Foscam_Camera&productName=ICS2030&appOemCode=&ipcUid=PNVX3P7T8SJWZKIAZZZZ&password=&supportStore=1&supportRichMedia=1&sbvzggsw=bda288dbe05adee8ca06dc20d6283486&productType=0&deviceType=2&sysVersion=1.14.2.4&clientId=foscloud&ip=192.168.3.81&oemCode=&ddns=&accessToken=d618d5fb437c4972a65131ea0aa017c7&version=1.0.0.150109-PRD&ipMediaPort=&supportCrv=1&ddnsPort=88&additionInfo=&supportAlexa=1&hasusertag=2&ipPort=88&supportP2p=1&macAddr=C46E7BA34B1B&username=admin|appInfo:PCGM00#11##22.21.16 (150408-454906765)||";
//
//        String oldUid=tt.split("ipcUid=")[1].split("&")[0];
//        String newUid="WdpPNVX3P7T3B8SJWZKIAZZZZ9Y7I";
//        //System.out.println("uid="+tt.split("ipcUid=")[1].split("&")[0]);
//
//        tt= tt.replace(oldUid,newUid);
//        System.out.println("tt:"+tt);
//
//
//        System.out.println("随机字符串："+createRandomStr1(1));
//
//        String uid="12345678ABCDEFGHZZZZ";
//        String firstStr=uid.substring(0,8);
//        String lastStr=uid.substring(8,uid.length());
//        String str=createRandomStr1(3)+firstStr+createRandomStr1(2)+lastStr;
//        System.out.println("str="+str);

//        List<Integer> integers= new ArrayList<Integer>();
//        for (int i = 0; i <5 ; i++) {
//            integers.add(i);
//        }
//       Integer [] lens= new Integer[]{1,2,3,4,5,6,7,8};
//        System.out.println(new Gson().toJson(integers.toArray(lens)));


//        long date1=1654162500;
//        long date2=1654162505;
//        System.out.println("diff="+(date2-date1));
//        System.out.println("curr="+System.currentTimeMillis()/1000);
//
//        long s=Long.valueOf("1654162505");
//        System.out.println(s);
    }


    private  static void  testBeijingTime(){
        // 已知的北京时区时间戳（毫秒）
        long beijingTimestamp = 1764058569666L;

        // 方法1：直接使用（因为时间戳本身是UTC基准的）
        long utcTimestamp = beijingTimestamp;

        // 方法2：如果需要验证，可以显示对应的时间
        java.util.Date date = new java.util.Date(beijingTimestamp);
        java.text.SimpleDateFormat sdfBeijing = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.text.SimpleDateFormat sdfUTC = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        sdfBeijing.setTimeZone(java.util.TimeZone.getTimeZone("Asia/Shanghai"));
        sdfUTC.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));

        System.out.println("北京时区时间戳: " + beijingTimestamp);
        System.out.println("对应北京时间: " + sdfBeijing.format(date));
        System.out.println("对应UTC时间: " + sdfUTC.format(date));
        System.out.println("UTC时间戳: " + utcTimestamp);
    }


















    /**
     * 返回字符串中  非数字 的字符串
     *
     * @param mixStr
     * @return
     */
    public static String getStrInMixString(String mixStr) {
        String regEx = "[0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(mixStr);
        return m.replaceAll("");
    }


    public static void BytePrintAsString(byte[] byteArray) {
        for (int i = 0; i < byteArray.length; i++) {
            String hex = Integer.toHexString(byteArray[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            System.out.print(hex.toUpperCase());
        }
        System.out.println();
    }


    /**
     * 汉字转unicode
     *
     * @param s
     * @return
     */
    public static String toUnicode(String s) {
        String as[] = new String[s.length()];
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            as[i] = Integer.toHexString(s.charAt(i) & 0xffff);
            s1 = s1 + as[i] + "\t";

        }
        return s1;
    }


    /**
     * 字符转unicode
     *
     * @param str
     * @return
     */
    public static String stringToUnicode(String str) {
        StringBuilder unicodeStr = new StringBuilder(str.length());
        java.util.Formatter f = new java.util.Formatter(unicodeStr);
        for (char c : str.toCharArray()) {
            f.format("%04x", (int) c);
        }
        try {
            return URLEncoder.encode(unicodeStr.toString(), "UTF-8");
        } catch (Exception e) {
        }
        return "";
    }


    /**
     * 汉字转十六进制
     *
     * @param s
     * @return
     */
    public static String toChineseHex(String s) {
        String ss = s;
        byte[] bt = ss.getBytes();
        String s1 = "";
        for (int i = 0; i < bt.length; i++) {
            String tempstr = Integer.toHexString(bt[i]);
            if (tempstr.length() > 2)
                tempstr = tempstr.substring(tempstr.length() - 2);
            s1 = s1 + tempstr + " ";
        }
        return s1.toUpperCase();
    }


    /**
     * 1.生成的字符串每个位置都有可能是str中的一个字母或数字，需要导入的包是import java.util.Random;
     *
     * @param length
     * @return
     */
    public static String createRandomStr1(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            stringBuffer.append(str.charAt(number));

        }
        return stringBuffer.toString();
    }

    /**
     * （低字节序）
     * 将int转为低字节在前，高字节在后的byte数组
     */
    public static byte[] toLH(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }

    private static void getAndroidLongLog() {
        String jsonStr = "[{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"xiangling\",\"id\":\"5838e0dc673182db8724914dd19b4bb7\",\"property\":\"deviceName\",\"propertyName\":\"设备名称\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\",\"storageType\":\"direct\"},\"id\":\"deviceName\",\"name\":\"Device Name\",\"valueType\":{\"expands\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"type\":\"STRING\",\"value\":\"xiangling\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"{\\\"password\\\":\\\"963cb137\\\",\\\"username\\\":\\\"admin\\\"}\",\"id\":\"249f1cf28d30ab87fa5145a65a2c51cd\",\"property\":\"securityConfig\",\"propertyName\":\"安全设置\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\",\"storageType\":\"direct\"},\"id\":\"securityConfig\",\"name\":\"Security Settings\",\"valueType\":{\"properties\":{\"username\":{\"id\":\"username\",\"name\":\"Username\",\"valueType\":{\"expands\":{\"maxLength\":\"60\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"password\":{\"id\":\"password\",\"name\":\"Password\",\"valueType\":{\"expands\":{\"maxLength\":\"60\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}}},\"type\":\"object\",\"valueType\":\"OBJECT\"}},\"type\":\"OBJECT\",\"value\":\"{\\\"password\\\":\\\"963cb137\\\",\\\"username\\\":\\\"admin\\\"}\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"Bell Tone\",\"id\":\"1a304907b8e58b4d8493c63bb66737cb\",\"property\":\"ringSound\",\"propertyName\":\"铃声类型\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"ringSound\",\"name\":\"Ringtone\",\"valueType\":{\"elements\":{\"0\":{\"id\":\"0\",\"text\":\"叮咚\",\"value\":\"0\"},\"1\":{\"id\":\"2\",\"text\":\"钟声\",\"value\":\"1\"},\"2\":{\"id\":\"3\",\"text\":\"犬吠声\",\"value\":\"2\"},\"3\":{\"id\":\"4\",\"text\":\"老式电话铃声\",\"value\":\"3\"},\"4\":{\"id\":\"5\",\"text\":\"钢琴声\",\"value\":\"4\"}},\"type\":\"enum\",\"valueType\":\"ENUM\"}},\"type\":\"ENUM\",\"value\":\"1\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"开\",\"id\":\"243cb8efea79af757e336f7a5c42d6da\",\"property\":\"nightLight\",\"propertyName\":\"小夜灯手动\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"nightLight\",\"name\":\"Night Light Manual\",\"valueType\":{\"falseText\":\"关\",\"falseValue\":\"false\",\"trueText\":\"开\",\"trueValue\":\"true\",\"type\":\"boolean\",\"valueType\":\"BOOLEAN\"}},\"type\":\"BOOLEAN\",\"value\":\"true\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"开\",\"id\":\"2b6c5473947431a9a27750a4c91e1f41\",\"property\":\"indicatorLight\",\"propertyName\":\"指示灯\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"indicatorLight\",\"name\":\"Indicator Light\",\"valueType\":{\"falseText\":\"关\",\"falseValue\":\"false\",\"trueText\":\"开\",\"trueValue\":\"true\",\"type\":\"boolean\",\"valueType\":\"BOOLEAN\"}},\"type\":\"BOOLEAN\",\"value\":\"true\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"5s\",\"id\":\"8b692e834d0fb323a508eb6eec7bf96e\",\"property\":\"ringDuration\",\"propertyName\":\"响铃时长\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"ringDuration\",\"name\":\"Ringtone Duration\",\"valueType\":{\"max\":\"\",\"min\":\"\",\"step\":\"\",\"type\":\"int\",\"unit\":\"seconds\",\"valueType\":\"NUMBER\"}},\"type\":\"NUMBER\",\"value\":\"5\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"83\",\"id\":\"5f5d4eff5e220a5bde0436b7790a72d9\",\"property\":\"wifiStrength\",\"propertyName\":\"Wi-Fi强度\",\"tslProperty\":{\"expand\":{\"readOnly\":true,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"wifiStrength\",\"name\":\"Wi-Fi Strength\",\"valueType\":{\"max\":\"\",\"min\":\"\",\"step\":\"\",\"type\":\"int\",\"unit\":\"\",\"valueType\":\"NUMBER\"}},\"type\":\"NUMBER\",\"value\":\"83\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"1.0.0.16\",\"id\":\"25fcbd935cd93d0d9281ef261c311709\",\"property\":\"firmwareVersion\",\"propertyName\":\"固件版本\",\"tslProperty\":{\"expand\":{\"readOnly\":true,\"ruleCondition\":false,\"ru" +
                "D: leExec\":false,\"source\":\"device\"},\"id\":\"firmwareVersion\",\"name\":\"Firmware Version\",\"valueType\":{\"expands\":{\"maxLength\":\"30\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"type\":\"STRING\",\"value\":\"1.0.0.16\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"{\\\"soundSensitivity\\\":\\\"Middle\\\",\\\"soundDetectSwitch\\\":\\\"开\\\"}\",\"id\":\"37ed4928625d7854f32dcc9d7321d16e\",\"property\":\"soundDetect\",\"propertyName\":\"小夜灯自动\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"soundDetect\",\"name\":\"Night Light Auto\",\"valueType\":{\"properties\":{\"soundDetectSwitch\":{\"id\":\"soundDetectSwitch\",\"name\":\"SoundDetectSwitch\",\"valueType\":{\"falseText\":\"关\",\"falseValue\":\"false\",\"trueText\":\"开\",\"trueValue\":\"true\",\"type\":\"boolean\",\"valueType\":\"BOOLEAN\"}},\"soundSensitivity\":{\"id\":\"soundSensitivity\",\"name\":\"SoundSensitivity\",\"valueType\":{\"elements\":{\"1\":{\"id\":\"0\",\"text\":\"Lowest\",\"value\":\"1\"},\"2\":{\"id\":\"2\",\"text\":\"Low\",\"value\":\"2\"},\"3\":{\"id\":\"3\",\"text\":\"Middle\",\"value\":\"3\"},\"4\":{\"id\":\"4\",\"text\":\"High\",\"value\":\"4\"},\"5\":{\"id\":\"5\",\"text\":\"Highest\",\"value\":\"5\"}},\"type\":\"enum\",\"valueType\":\"ENUM\"}}},\"type\":\"object\",\"valueType\":\"OBJECT\"}},\"type\":\"OBJECT\",\"value\":\"{\\\"soundSensitivity\\\":\\\"3\\\",\\\"soundDetectSwitch\\\":true}\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"{\\\"psk\\\":\\\"MTIzNDU2Nzg\\u003d\\\",\\\"ssid\\\":\\\"RG9ja2Vy\\\"}\",\"id\":\"5e1a422b7bfda7a3c2add9b3158f5b9d\",\"property\":\"apSetting\",\"propertyName\":\"连接路由器信息\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"apSetting\",\"name\":\"Router Information\",\"valueType\":{\"properties\":{\"ssid\":{\"id\":\"ssid\",\"name\":\"SSID\",\"valueType\":{\"expands\":{\"encodeType\":\"base64\",\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"psk\":{\"id\":\"psk\",\"name\":\"PSK\",\"valueType\":{\"expands\":{\"encodeType\":\"base64\",\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}}},\"type\":\"object\",\"valueType\":\"OBJECT\"}},\"type\":\"OBJECT\",\"value\":\"{\\\"psk\\\":\\\"MTIzNDU2Nzg\\u003d\\\",\\\"ssid\\\":\\\"RG9ja2Vy\\\"}\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"{\\\"psk\\\":\\\"MTIzNDU2Nzg\\u003d\\\",\\\"ssid\\\":\\\"RG9ja2VyXzIuNEc\\u003d\\\"}\",\"id\":\"d755334b5953f760143f211e4052651b\",\"property\":\"wap24GSetting\",\"propertyName\":\"中继热点2.4g信息\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"wap24GSetting\",\"name\":\"2.4G Hotspot Information\",\"valueType\":{\"properties\":{\"ssid\":{\"id\":\"ssid\",\"name\":\"SSID\",\"valueType\":{\"expands\":{\"encodeType\":\"base64\",\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"psk\":{\"id\":\"psk\",\"name\":\"PSK\",\"valueType\":{\"expands\":{\"encodeType\":\"base64\",\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}}},\"type\":\"object\",\"valueType\":\"OBJECT\"}},\"type\":\"OBJECT\",\"value\":\"{\\\"psk\\\":\\\"MTIzNDU2Nzg\\u003d\\\",\\\"ssid\\\":\\\"RG9ja2VyXzIuNEc\\u003d\\\"}\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"{\\\"psk\\\":\\\"MTIzNDU2Nzg\\u003d\\\",\\\"ssid\\\":\\\"RG9ja2VyXzVH\\\"}\",\"id\":\"3c8786eec8ee1d69b87796a0faa3183e\",\"property\":\"wap5GSetting\",\"propertyName\":\"中继热点5g信息\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"wap5GSetting\",\"name\":\"5G Hotspot Information\",\"valueType\":{\"properties\":{\"ssid\":{\"id\":\"ssid\",\"name\":\"SSID\",\"valueType\":{\"expands\":{\"encodeType\":\"base64\",\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"psk\":{\"id\":\"psk\",\"name\":\"PSK\",\"valueType\":{\"expands\":{\"encodeType\":\"base64\",\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}}},\"type\":\"object\",\"valueType\":\"OBJECT\"}},\"type\":\"OBJECT\",\"value\":\"{\\\"psk\\\":\\\"MTIz" +
                "D: NDU2Nzg\\u003d\\\",\\\"ssid\\\":\\\"RG9ja2VyXzVH\\\"}\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"{\\\"dns2\\\":\\\"172.16.40.3\\\",\\\"ip\\\":\\\"192.168.1.103\\\",\\\"dns1\\\":\\\"8.8.4.4\\\",\\\"gateway\\\":\\\"192.168.1.1\\\",\\\"mask\\\":\\\"255.255.255.0\\\"}\",\"id\":\"dbcd154d2866cc7793ffb4ffbb9a6119\",\"property\":\"deviceIP\",\"propertyName\":\"设备IP信息\",\"tslProperty\":{\"expand\":{\"readOnly\":true,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"deviceIP\",\"name\":\"IP Information\",\"valueType\":{\"properties\":{\"ip\":{\"id\":\"ip\",\"name\":\"ip\",\"valueType\":{\"expands\":{\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"mask\":{\"id\":\"mask\",\"name\":\"mask\",\"valueType\":{\"expands\":{\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"gateway\":{\"id\":\"gateway\",\"name\":\"gateway\",\"valueType\":{\"expands\":{\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"dns1\":{\"id\":\"dns1\",\"name\":\"dns1\",\"valueType\":{\"expands\":{\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}},\"dns2\":{\"id\":\"dns2\",\"name\":\"dns2\",\"valueType\":{\"expands\":{\"maxLength\":\"255\",\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false},\"type\":\"string\",\"valueType\":\"STRING\"}}},\"type\":\"object\",\"valueType\":\"OBJECT\"}},\"type\":\"OBJECT\",\"value\":\"{\\\"dns2\\\":\\\"172.16.40.3\\\",\\\"ip\\\":\\\"192.168.1.103\\\",\\\"dns1\\\":\\\"8.8.4.4\\\",\\\"gateway\\\":\\\"192.168.1.1\\\",\\\"mask\\\":\\\"255.255.255.0\\\"}\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"启用\",\"id\":\"f335e551c8c61efd7bc1fb61712acb77\",\"property\":\"autoUpgrade\",\"propertyName\":\"自动升级\",\"tslProperty\":{\"expand\":{\"readOnly\":true,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"autoUpgrade\",\"name\":\"Auto Upgrade\",\"valueType\":{\"falseText\":\"禁用\",\"falseValue\":\"false\",\"trueText\":\"启用\",\"trueValue\":\"true\",\"type\":\"boolean\",\"valueType\":\"BOOLEAN\"}},\"type\":\"BOOLEAN\",\"value\":\"true\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"{\\\"nlScheduleSwitch\\\":\\\"关\\\",\\\"startTime\\\":\\\"00:00\\\",\\\"endTime\\\":\\\"24:00\\\"}\",\"id\":\"cfd9cfa0076bea270043b1c5e2515719\",\"property\":\"nlSchedule\",\"propertyName\":\"小夜灯计划\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\",\"storageType\":\"direct\"},\"id\":\"nlSchedule\",\"name\":\"Night Light Schedule\",\"valueType\":{\"properties\":{\"nlScheduleSwitch\":{\"id\":\"nlScheduleSwitch\",\"name\":\"NlScheduleSwitch\",\"valueType\":{\"falseText\":\"关\",\"falseValue\":\"false\",\"trueText\":\"开\",\"trueValue\":\"true\",\"type\":\"boolean\",\"valueType\":\"BOOLEAN\"}},\"startTime\":{\"id\":\"startTime\",\"name\":\"StartTime\",\"valueType\":{\"format\":\"HH:mm\",\"type\":\"time\",\"tz\":\"\",\"valueType\":\"DATE\"}},\"endTime\":{\"id\":\"endTime\",\"name\":\"EndTime\",\"valueType\":{\"format\":\"HH:mm\",\"type\":\"time\",\"tz\":\"\",\"valueType\":\"DATE\"}}},\"type\":\"object\",\"valueType\":\"OBJECT\"}},\"type\":\"OBJECT\",\"value\":\"{\\\"nlScheduleSwitch\\\":false,\\\"startTime\\\":\\\"00:00\\\",\\\"endTime\\\":\\\"24:00\\\"}\",\"mode_type\":0},{\"formatValue\":\"\",\"id\":\"deviceReset\",\"property\":\"deviceReset\",\"propertyName\":\"重置设备\",\"type\":\"FUNCTION\",\"value\":\"\",\"mode_type\":0},{\"deviceId\":\"DC4EF40987B8\",\"formatValue\":\"80%\",\"id\":\"c6ce3854abfeb42e08fe449be247e7a4\",\"property\":\"volume\",\"propertyName\":\"音量\",\"tslProperty\":{\"expand\":{\"readOnly\":false,\"ruleCondition\":false,\"ruleExec\":false,\"source\":\"device\"},\"id\":\"volume\",\"name\":\"Volume\",\"valueType\":{\"max\":\"\",\"min\":\"\",\"step\":\"\",\"type\":\"int\",\"unit\":\"percent\",\"valueType\":\"NUMBER\"}},\"type\":\"NUMBER\",\"value\":\"80\",\"mode_type\":0},{\"formatValue\":\"\",\"id\":\"deviceReboot\",\"property\":\"deviceReboot\",\"propertyName\":\"重启设备\",\"type\":\"FUNCTION\",\"value\":\"\",\"mode_type\":0}]";
        String jsonStrLanguage = "{\"data\":[{\"metadataId\":\"i18n.tsl.resource.productName\",\"productId\":\"standart-chime\",\"createTime\":1639644278353,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"Product Name\",\"metadataDescription\":\"\",\"id\":\"aaca9d5a907982275169e35935d64a55\",\"deviceMetadataType\":null},{\"metadataId\":\"macAddr\",\"productId\":\"standart-chime\",\"createTime\":1639644278353,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"mac地址\",\"metadataDescription\":\"\",\"id\":\"55a4d9bafe0d220b8d99f26fb55d207d\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceName\",\"productId\":\"standart-chime\",\"createTime\":1639644278354,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"设备名称\",\"metadataDescription\":\"\",\"id\":\"d37ec3708b231ee499cb83088dcecb0a\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ringSound\",\"productId\":\"standart-chime\",\"createTime\":1639644278354,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"铃声类型\",\"metadataDescription\":\"\",\"id\":\"00ab345c5f1c6c24de7f6fdbd7ea97e3\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ringSound.0\",\"productId\":\"standart-chime\",\"createTime\":1639644278354,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"叮咚\",\"metadataDescription\":\"\",\"id\":\"85a13c9d7951862ff356a539dc58c10a\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ringSound.1\",\"productId\":\"standart-chime\",\"createTime\":1639644278354,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"钟声\",\"metadataDescription\":\"\",\"id\":\"16cd43a7b7ef88ecb402e1f4b2670b3d\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ringSound.2\",\"productId\":\"standart-chime\",\"createTime\":1639644278355,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"犬吠声\",\"metadataDescription\":\"\",\"id\":\"73064c7aed7ccb45c64f126bce63981b\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ringSound.3\",\"productId\":\"standart-chime\",\"createTime\":1639644278355,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"老式电话铃声\",\"metadataDescription\":\"\",\"id\":\"817b641f538ea92a7fa1e1c2dbe63d0c\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ringSound.4\",\"productId\":\"standart-chime\",\"createTime\":1639644278355,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"钢琴声\",\"metadataDescription\":\"\",\"id\":\"3848af943aed61ca6c65e45dcb7d2ddb\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nightLight\",\"productId\":\"standart-chime\",\"createTime\":1639644278355,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"小夜灯手动\",\"metadataDescription\":\"\",\"id\":\"05458f30801565fb6915ce0c6035f373\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nightLight.true\",\"productId\":\"standart-chime\",\"createTime\":1639644278355,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"开\",\"metadataDescription\":\"\",\"id\":\"3403096b7b4956f577c1a5b829d0d6f2\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nightLight.false\",\"productId\":\"standart-chime\",\"createTime\":1639644278356,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"关\",\"metadataDescription\":\"\",\"id\":\"fa8c9683f7419adaa41bfe556a2d1aa8\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"indicatorLight\",\"productId\":\"standart-chime\",\"createTime\":1639644278356,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"指示灯\",\"metadataDescription\":\"\",\"id\":\"b157e6dfa74b6e8000c0420312f64eed\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"indicatorLight.true\",\"productId\":\"standart-chime\",\"createTime\":1639644278356,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"开\",\"metadataDescription\":\"" +
                "D: \",\"id\":\"7059df060b1bf7eee3cbae1b2a46da29\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"indicatorLight.false\",\"productId\":\"standart-chime\",\"createTime\":1639644278356,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"关\",\"metadataDescription\":\"\",\"id\":\"807065ba09e1d01ef78db183e3b7838f\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ringDuration\",\"productId\":\"standart-chime\",\"createTime\":1639644278356,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"响铃时长\",\"metadataDescription\":\"\",\"id\":\"de9f0e85ae804f5897487d70958c66d7\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"wifiStrength\",\"productId\":\"standart-chime\",\"createTime\":1639644278356,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"Wi-Fi强度\",\"metadataDescription\":\"\",\"id\":\"fbffddb3ea82604901f3507dce9885e8\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"volume\",\"productId\":\"standart-chime\",\"createTime\":1639644278357,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"音量\",\"metadataDescription\":\"\",\"id\":\"aa69e2150b5962f01c03602e915148d2\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"firmwareVersion\",\"productId\":\"standart-chime\",\"createTime\":1639644278357,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"固件版本\",\"metadataDescription\":\"\",\"id\":\"acf78cbacae6440d35aaef76f186f383\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"sysVersion\",\"productId\":\"standart-chime\",\"createTime\":1639644278357,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"系统版本\",\"metadataDescription\":\"\",\"id\":\"83afb4f2628e64ef8a2daa0559a9407e\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"productName\",\"productId\":\"standart-chime\",\"createTime\":1639644278357,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"产品名称\",\"metadataDescription\":\"\",\"id\":\"db592054cf9cfdb3cd9a44bd124d0b8c\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"oemCode\",\"productId\":\"standart-chime\",\"createTime\":1639644278357,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"oem客户定制\",\"metadataDescription\":\"\",\"id\":\"b8cc244ac962aca4ef0fe5822a00d522\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"resetStatus\",\"productId\":\"standart-chime\",\"createTime\":1639644278357,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"设备复位标识\",\"metadataDescription\":\"\",\"id\":\"b9268a7105e084541acb9f607ef0bfdf\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"resetStatus.0\",\"productId\":\"standart-chime\",\"createTime\":1639644278358,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"正常\",\"metadataDescription\":\"\",\"id\":\"07ec3d44bb67c77e468c4dc2240b45ed\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"resetStatus.1\",\"productId\":\"standart-chime\",\"createTime\":1639644278358,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"复位\",\"metadataDescription\":\"\",\"id\":\"c3f7d6c1b5119c25339a453ec1f3a153\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"capability\",\"productId\":\"standart-chime\",\"createTime\":1639644278358,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"设备能力集\",\"metadataDescription\":\"\",\"id\":\"acfc1d5caa21d3d3a49914aa5afc216c\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect\",\"productId\":\"standart-chime\",\"createTime\":1639644278358,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"小夜灯自动\",\"metadataDescription\":\"\",\"id\":\"44be8c804d5d0b84947f7dd786efe0ae\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundDetectSwitch\",\"productId\":\"standart-chime\",\"createTime\":1639644278358,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"c" +
                "D: reatorName\":\"foscam\",\"metadataName\":\"检测到声音亮灯\",\"metadataDescription\":\"\",\"id\":\"4131cf315e10f6f638d689088b26c78c\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundDetectSwitch.true\",\"productId\":\"standart-chime\",\"createTime\":1639644278359,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"开\",\"metadataDescription\":\"\",\"id\":\"6c4234d88423ac6384da40f1effc183f\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundDetectSwitch.false\",\"productId\":\"standart-chime\",\"createTime\":1639644278359,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"关\",\"metadataDescription\":\"\",\"id\":\"e83c40404e3e2341b1e37d6f1cb62ce0\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundSensitivity\",\"productId\":\"standart-chime\",\"createTime\":1639644278360,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"声音侦测灵敏度\",\"metadataDescription\":\"\",\"id\":\"3853cb9ffc06baa002e76eb47bccae15\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundSensitivity.1\",\"productId\":\"standart-chime\",\"createTime\":1639644278360,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"最低\",\"metadataDescription\":\"\",\"id\":\"961fa4b29cca1b82b55b6b905b3307ea\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundSensitivity.2\",\"productId\":\"standart-chime\",\"createTime\":1639644278360,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"低\",\"metadataDescription\":\"\",\"id\":\"71080b993bb35ac4b37913f70ad8789c\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundSensitivity.3\",\"productId\":\"standart-chime\",\"createTime\":1639644278360,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"中\",\"metadataDescription\":\"\",\"id\":\"81d0c6b5078876689d74a6f7d9d7cc41\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundSensitivity.4\",\"productId\":\"standart-chime\",\"createTime\":1639644278360,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"高\",\"metadataDescription\":\"\",\"id\":\"bfa53ef3e3b1e05bb165905acf6ed2b0\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"soundDetect.soundSensitivity.5\",\"productId\":\"standart-chime\",\"createTime\":1639644278361,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"最高\",\"metadataDescription\":\"\",\"id\":\"a79125b78f8bf4bc66221605af536269\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ivyExtendFlag\",\"productId\":\"standart-chime\",\"createTime\":1639644278361,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"爱为物联专用扩展属性\",\"metadataDescription\":\"\",\"id\":\"326dbf187e315695f75134cb6539c01c\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"ivyExtendFlag.migrate\",\"productId\":\"standart-chime\",\"createTime\":1639644278361,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"旧设备升级迁移\",\"metadataDescription\":\"\",\"id\":\"dfda19c366607b7b64a8328d6b2e250d\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"apSetting\",\"productId\":\"standart-chime\",\"createTime\":1639644278361,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"连接路由器信息\",\"metadataDescription\":\"\",\"id\":\"62e007d9475d492b20b7c767ecc2185b\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"apSetting.ssid\",\"productId\":\"standart-chime\",\"createTime\":1639644278361,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"SSID\",\"metadataDescription\":\"\",\"id\":\"af58a306cf805527ea523dd760128335\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"apSetting.psk\",\"productId\":\"standart-chime\",\"createTime\":1639644278367,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"PSK\",\"metadataDescription\":\"\"" +
                "D: ,\"id\":\"3d235b7b055530d960ef0b0a25159d4f\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"wap24GSetting\",\"productId\":\"standart-chime\",\"createTime\":1639644278367,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"中继热点2.4g信息\",\"metadataDescription\":\"\",\"id\":\"36bceaa25a8d634024289ebd60b02265\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"wap24GSetting.ssid\",\"productId\":\"standart-chime\",\"createTime\":1639644278367,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"SSID\",\"metadataDescription\":\"\",\"id\":\"5fa5320165a55341a8b68f7a7915ab49\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"wap24GSetting.psk\",\"productId\":\"standart-chime\",\"createTime\":1639644278367,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"PSK\",\"metadataDescription\":\"\",\"id\":\"36c3f480f67afbd0dca44f9c9da7d9fb\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"wap5GSetting\",\"productId\":\"standart-chime\",\"createTime\":1639644278367,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"中继热点5g信息\",\"metadataDescription\":\"\",\"id\":\"996640ffec1b1f357d2b4d93bb79d31e\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"wap5GSetting.ssid\",\"productId\":\"standart-chime\",\"createTime\":1639644278367,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"SSID\",\"metadataDescription\":\"\",\"id\":\"6f8a1a5167a6d043d4dc919587efe3a3\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"wap5GSetting.psk\",\"productId\":\"standart-chime\",\"createTime\":1639644278368,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"PSK\",\"metadataDescription\":\"\",\"id\":\"bedbe60d52467ca8f3e8ada7c046c6fb\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceIP\",\"productId\":\"standart-chime\",\"createTime\":1639644278368,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"设备IP信息\",\"metadataDescription\":\"\",\"id\":\"c0d64bf928e18b10221575565fb6c709\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceIP.ip\",\"productId\":\"standart-chime\",\"createTime\":1639644278368,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"IP\",\"metadataDescription\":\"\",\"id\":\"aa2dc862f184100a60bac5c8853b53c9\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceIP.mask\",\"productId\":\"standart-chime\",\"createTime\":1639644278368,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"子网掩码\",\"metadataDescription\":\"\",\"id\":\"77fd4d11855dd85a4a684616b4069814\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceIP.gateway\",\"productId\":\"standart-chime\",\"createTime\":1639644278368,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"默认网关\",\"metadataDescription\":\"\",\"id\":\"5207e27ca75b8eebf9d6df7af4eb8b25\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceIP.dns1\",\"productId\":\"standart-chime\",\"createTime\":1639644278368,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"DNS1\",\"metadataDescription\":\"\",\"id\":\"a5ec00b23927a33ec55b00b802eeb8d7\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceIP.dns2\",\"productId\":\"standart-chime\",\"createTime\":1639644278368,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"DNS2\",\"metadataDescription\":\"\",\"id\":\"a0cefd21cbe3d1ceff12342892565e43\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"autoUpgrade\",\"productId\":\"standart-chime\",\"createTime\":1639644278369,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"自动升级\",\"metadataDescription\":\"\",\"id\":\"47f7a094b7495edd7eec78ee0259146b\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"autoUpgrade.true\",\"productId\":\"standart-chime\",\"createTime\":1639644278369,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"f" +
                "D: oscam\",\"metadataName\":\"启用\",\"metadataDescription\":\"\",\"id\":\"8811169eb98afc86f519dd5b42104e05\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"autoUpgrade.false\",\"productId\":\"standart-chime\",\"createTime\":1639644278369,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"禁用\",\"metadataDescription\":\"\",\"id\":\"59caafff94a678697986cf588f1927ce\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"securityConfig\",\"productId\":\"standart-chime\",\"createTime\":1639644278369,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"安全设置\",\"metadataDescription\":\"\",\"id\":\"e31bb144ea55f25b8de349e56b5c2bff\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"securityConfig.username\",\"productId\":\"standart-chime\",\"createTime\":1639644278369,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"用户名\",\"metadataDescription\":\"\",\"id\":\"6a0ff62243582e49e38eeaa315a96476\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"securityConfig.password\",\"productId\":\"standart-chime\",\"createTime\":1639644278369,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"密码\",\"metadataDescription\":\"\",\"id\":\"a6a4cde08f8c875bfe23ff7ac7711b35\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nlSchedule\",\"productId\":\"standart-chime\",\"createTime\":1639644278369,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"小夜灯计划\",\"metadataDescription\":\"\",\"id\":\"f2778e4a453b09a6bb958a2620124196\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nlSchedule.nlScheduleSwitch\",\"productId\":\"standart-chime\",\"createTime\":1639644278370,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"计划内亮灯\",\"metadataDescription\":\"\",\"id\":\"ee43bc6b7dcdb62781575bddcf8fd980\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nlSchedule.nlScheduleSwitch.true\",\"productId\":\"standart-chime\",\"createTime\":1639644278370,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"开\",\"metadataDescription\":\"\",\"id\":\"7e41746a00a06832522b75e845ab05d2\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nlSchedule.nlScheduleSwitch.false\",\"productId\":\"standart-chime\",\"createTime\":1639644278370,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"关\",\"metadataDescription\":\"\",\"id\":\"c5c9e1525e9578e922641d04040c6b53\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nlSchedule.startTime\",\"productId\":\"standart-chime\",\"createTime\":1639644278370,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"开始时间\",\"metadataDescription\":\"\",\"id\":\"c1ca4068c3ed8960e3e075dc37b3089e\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"nlSchedule.endTime\",\"productId\":\"standart-chime\",\"createTime\":1639644278370,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"结束时间\",\"metadataDescription\":\"\",\"id\":\"9f37c7c4e19f0a9d68a6cf5bc5c2cca6\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceTime\",\"productId\":\"standart-chime\",\"createTime\":1639644278370,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"设备时间\",\"metadataDescription\":\"\",\"id\":\"1eacda90eab6525f4ef7685e5d8906a1\",\"deviceMetadataType\":\"property\"},{\"metadataId\":\"deviceReset\",\"productId\":\"standart-chime\",\"createTime\":1639644278370,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"重置设备\",\"metadataDescription\":\"\",\"id\":\"574714c2aad6f7de08441c201f6cff2a\",\"deviceMetadataType\":\"event\"},{\"metadataId\":\"deviceReboot\",\"productId\":\"standart-chime\",\"createTime\":1639644278370,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"重启设备\",\"metadataDescription\":\"\",\"id\":\"c03614eb0458646d22a54b471d777d4b\",\"deviceMetadataType\":\"function\"},{\"metadataId\":\"deviceRe" +
                "D: set\",\"productId\":\"standart-chime\",\"createTime\":1639644278371,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"foscam\",\"metadataName\":\"重置设备\",\"metadataDescription\":\"\",\"id\":\"dcba45bc8fe3977ae3dc931dbbca1983\",\"deviceMetadataType\":\"function\"},{\"metadataId\":\"ringing\",\"productId\":\"standart-chime\",\"createTime\":1639628388432,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"福斯康姆\",\"metadataName\":\"响铃\",\"metadataDescription\":\"\",\"id\":\"4c327e3181ee2faa7d43cc2e4a6047fe\",\"deviceMetadataType\":\"function\"},{\"metadataId\":\"ringing.soundType\",\"productId\":\"standart-chime\",\"createTime\":1639628388432,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"福斯康姆\",\"metadataName\":\"铃声类型\",\"metadataDescription\":\"\",\"id\":\"d94e0731d79948c05f9e052d9a81e8ba\",\"deviceMetadataType\":\"functionParameter\"},{\"metadataId\":\"ringing.soundType.0\",\"productId\":\"standart-chime\",\"createTime\":1639628388432,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"福斯康姆\",\"metadataName\":\"叮咚\",\"metadataDescription\":\"\",\"id\":\"30c070098ce0862b0c3e6f563dec37b1\",\"deviceMetadataType\":\"functionParameter\"},{\"metadataId\":\"ringing.soundType.1\",\"productId\":\"standart-chime\",\"createTime\":1639628388432,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"福斯康姆\",\"metadataName\":\"钟声\",\"metadataDescription\":\"\",\"id\":\"be2a564ecc73d175acaa90be092d604a\",\"deviceMetadataType\":\"functionParameter\"},{\"metadataId\":\"ringing.soundType.2\",\"productId\":\"standart-chime\",\"createTime\":1639628388432,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"福斯康姆\",\"metadataName\":\"犬吠声\",\"metadataDescription\":\"\",\"id\":\"7b1df3d828f7d86d99ec2ae00de499ac\",\"deviceMetadataType\":\"functionParameter\"},{\"metadataId\":\"ringing.soundType.3\",\"productId\":\"standart-chime\",\"createTime\":1639628388432,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"福斯康姆\",\"metadataName\":\"老式电话铃声\",\"metadataDescription\":\"\",\"id\":\"b04471c7b6ceb16bf5049b2d4f225d55\",\"deviceMetadataType\":\"functionParameter\"},{\"metadataId\":\"ringing.soundType.4\",\"productId\":\"standart-chime\",\"createTime\":1639628388432,\"languageId\":\"zh-CN\",\"creatorId\":\"1433004291434369024\",\"creatorName\":\"福斯康姆\",\"metadataName\":\"钢琴声\",\"metadataDescription\":\"\",\"id\":\"65c794fdfd433abdfc7afa72aca07ea2\",\"deviceMetadataType\":\"functionParameter\"}],\"failureDetails\":null,\"errorCode\":\"\"}";

        String str = "D: ";
        String json = jsonStrLanguage.replaceAll(str, "");
        System.out.println(json);
    }

    private static void getTimeDiff() {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
        try {
            Date fromDate = simpleFormat.parse("2016-05-01 12:00:03:000");
            Date toDate = simpleFormat.parse("2016-05-01 12:50:49:152");
            long from = 0;
            from = fromDate.getTime();
            long to = toDate.getTime();
            int minutes = (int) ((to - from) / (1000 * 60));
            int ss = (int) ((to - from) / (1000));
            long diff = to - from;
            System.out.println("minutes=" + minutes);
            System.out.println("ss=" + ss % 60);
            System.out.println("SSS=" + diff % 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("时间差：" + getDistanceTime("2016-05-01 12:00:00:000", "2016-05-01 12:50:02:157"));
    }


    /**
     * 统计两个时间的时间差
     * 相差几秒几毫秒
     */
    public static String getDistanceTime(String str1, String str2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date one;
        Date two;
        long day = 0;//天数差
        long hour = 0;//小时数差
        long min = 0;//分钟数差
        long second = 0;//秒数差
        long diff = 0;//毫秒差
        String result = null;
        try {
            final Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            one = df.parse(str1);
            c.setTime(one);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            diff = time2 - time1;
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            second = diff / 1000;
            System.out.println("day=" + day + " hour=" + hour + " min=" + min + " ss=" + second % 60 + " SSS=" + diff % 1000);
            result = second % 60 + "秒" + diff % 1000 + "毫秒";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    // 两次点击间隔不能少于1000ms
    private static final int FAST_CLICK_DELAY_TIME = 1000;
    private static long lastClickTime;

    public static boolean isFastClick() {
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) >= FAST_CLICK_DELAY_TIME) {
            flag = false;
        }
        lastClickTime = currentClickTime;
        return flag;
    }


    /**
     * 解析精确到秒的时间 转换为 XX:XX格式
     */
    public static String secForTime(long mill) {
        int hour = (int) (mill / 3600);
        int minutes = (int) ((mill / 60) % 60);
        int sec = (int) (mill % 60);
        System.out.println("hour=" + hour + " minutes=" + minutes + " sec:" + sec);
        return String.format(Locale.US, "%02d:%02d:%02d", hour, minutes, sec);
    }


    /**
     * 以0时区显示时间戳
     *
     * @param seconds 精确到秒的字符串
     * @param
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (format == null) {
            format = "HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }


    private static void testNull() {
        ArrayList<String> ownerPackageNames = new ArrayList<String>();

        ownerPackageNames.add("com.foscam.foscam");
        ownerPackageNames.add(null);
        System.out.println(ownerPackageNames.toString());

        if (ownerPackageNames.toString() == null) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }

        if (ownerPackageNames.toString().contains("null")) {
            System.out.println("contains null");
        } else {

        }
    }

    private static void testDateTime() {
        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = cal.getTimeZone();
        System.out.println(timeZone.getID());
        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.getRawOffset());

        List<String> strings = new ArrayList<String>();
        strings.add("111");
        strings.add("222");
        strings.add("111");
        strings.add("111");
        strings.add("111");

        strings.add(1, "555");

        System.out.printf("strings=" + strings.toString());

        // 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
//        long time = date.getTime();
//        System.out.println(time);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = null;
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);   //Mon Sep 02 00:00:00 CST 2019
        // date=new Date();
        long time = date.getTime() / 1000;//1638374400
        System.out.println("time:" + time);
        System.out.println("time:" + (time - 30 * 24 * 3600));
        //System.out.println(simpleDateFormat.format(date));  //2019-09-02


        System.out.println("date=" + getTitleDateTime("12-09-2021"));


        System.out.println("时区：" + getCurrentTimeZone());
    }


    private static void testBinaryString() {
        Long ability[] = {3206305475L, 3668557608L, 134397264L, 54L};
        System.out.println(Long.toBinaryString(54));
        System.out.println(Long.toString(ability[3]));
    }

    private static void testDecimalFormat() {
        double i = 0.21;
        System.out.println(String.valueOf(decimalFormat(i)));
    }

    private static void test() {
        int MAX_SCREEN_COUNT = 4;
        int Global = 5;
        int count = (Global / MAX_SCREEN_COUNT + (Global % MAX_SCREEN_COUNT > 0 ? 1 : 0)) * MAX_SCREEN_COUNT;
        System.out.println("count=" + count);
    }

    /**
     * 数字补零
     *
     * @param i
     * @return List<T>
     */
    public static String decimalFormat(double i) {
        return new DecimalFormat("#0.00").format(i);
    }


    private static long getTitleDateTime(String title) {
        String dateStr = title;
        String month = dateStr.split("-")[0];
        String day = dateStr.split("-")[1];
        String year = dateStr.split("-")[2];
        dateStr = year + "-" + month + "-" + day;
        dateStr = "2021-12-09 16:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime() / 1000;
    }


    /**
     * 秒转换为UTC时间
     *
     * @param second
     * @return
     */
    public static int secondToUTCTime(long second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(second * 1000);//转换为毫秒
        /** 取得时间偏移量 */
        int zoneOffset = calendar.get(java.util.Calendar.ZONE_OFFSET);
        /** 取得夏令时差 */
        int dstOffset = calendar.get(java.util.Calendar.DST_OFFSET);
        /** 从本地时间里扣除这些差量，即可以取得UTC时间*/
        calendar.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        return (int) (calendar.getTimeInMillis() / 1000);
    }


    /**
     * 获取当前时区 * @return
     */
    public static String getCurrentTimeZone() {
        TimeZone tz = TimeZone.getDefault();
        String strTz = tz.getDisplayName(false, TimeZone.SHORT);
        return strTz;

    }


    /**
     * 把long解析为对应的时间 ，总是一个开始时间、一个结束时间，有偶数个元素
     */
    public static ArrayList<String> transformAlertPlanTime(long mplanTime) {
        StringBuilder strPlanTime = new StringBuilder(Long.toBinaryString(mplanTime));
        try {
            // 48位不全，补全位数
            if (strPlanTime.length() < 48) {
                for (int i = 0; i < 48 - strPlanTime.length(); i++) {
                    strPlanTime.insert(0, "0");
                }
            }
            // strPlanTime字符串翻转
            String tempStrPlanTime = strPlanTime.toString();
            char[] arr = tempStrPlanTime.toCharArray();
            int length = tempStrPlanTime.length();
            for (int i = 0; i < length / 2; i++) {
                char temp = arr[i];
                arr[i] = arr[length - i - 1];
                arr[length - i - 1] = temp;
            }
            strPlanTime = new StringBuilder(String.valueOf(arr));

            ArrayList<String> planTime = new ArrayList<>();
            for (int i = 0; i < strPlanTime.length(); i++) {
                int startIndex = i;
                int endIndex = i + 1;
                if (endIndex == strPlanTime.length()) {
                    if (strPlanTime.charAt(startIndex) == '1') {
                        planTime.add("23:30");
                        planTime.add("24:00");
                    }
                }

                if (strPlanTime.charAt(i) == '1') {
                    String str = "00:00";
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm", Locale.US);

                    Calendar startCal, endCal;
                    Date myDate = formatter.parse(str);
                    startCal = Calendar.getInstance();
                    startCal.setTime(myDate);
                    endCal = Calendar.getInstance();
                    endCal.setTime(myDate);

                    for (int j = i + 1; j < strPlanTime.length(); j++) {
                        if (j < strPlanTime.length() && strPlanTime.charAt(j) == '0') {
                            endIndex = j;
                            startCal.add(Calendar.MINUTE, 30 * startIndex);
                            endCal.add(Calendar.MINUTE, 30 * endIndex);
                            if (startIndex == 0) {
                                planTime.add("00:00");
                            } else {
                                planTime.add(formatter.format(startCal.getTime()));
                            }
                            if (endIndex == 47) {
                                if (strPlanTime.charAt(47) == '1') {
                                    planTime.add("24:00");
                                } else {
                                    planTime.add("23:30");
                                }
                            } else {
                                planTime.add(formatter.format(endCal.getTime()));
                            }
                            i = endIndex;
                            break;
                        }
                        if (j == (strPlanTime.length() - 1) && (strPlanTime.charAt(j) == '1')) {
                            if (startIndex == 0) {
                                planTime.add("00:00");
                            } else {
                                startCal.add(Calendar.MINUTE, 30 * startIndex);
                                planTime.add(formatter.format(startCal.getTime()));
                            }
                            planTime.add("24:00");
                            i = j;
                            break;
                        }
                    }
                }
            }
            return planTime;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
