package eu.side.thomaspiron.android.Utility;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.model.APModele;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Contact;
import eu.side.thomaspiron.android.model.Land;
import eu.side.thomaspiron.android.model.Maison;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class Utility {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    public static String formatImageThumbUrl(String cptEpl){

        String eplEncoded  =cptEpl.replaceAll(" ", "%20");
        return "http://www.thomas-piron.eu/images/ensemble/rest/" + eplEncoded + "/MEDIA/" + eplEncoded + "_800_REF_1.jpg";
        //return "http://lorempixel.com/500/500/animals/1";
    }

    public static String formatImageThumUrl2(String cptEpl, int num){
        String eplEncoded  =cptEpl.replaceAll(" ", "%20");
        return "http://www.thomas-piron.eu/images/ensemble/rest/" + eplEncoded + "/MEDIA/" + eplEncoded + "_800_"+num+".jpg";
    }

    public static List<String> getAPFacades(String client){
        List<String> urls = new LinkedList<>();
        urls.add("http://www.inspiration-maison.com/ap/"+client+"-image-big.jpg");
        urls.add("http://www.inspiration-maison.com/ap/"+client+"-fac1-big.jpg");
        urls.add("http://www.inspiration-maison.com/ap/"+client+"-fac2-big.jpg");
        urls.add("http://www.inspiration-maison.com/ap/"+client+"-coupe-big.jpg");
        return urls;
    }

    public static String[] getListMediasEnsemble(String cptEpl, int nb){
        String[] urls;
        if(nb >= 5) {
            urls = new String[nb];
        }
        else{
            urls = new String[5];
        }
        if (nb > 0) {
            urls[0] = formatImageThumbUrl(cptEpl);
            for (int i = 1; i < nb; i++) {
                urls[i] = formatImageThumUrl2(cptEpl, i+1);
            }
        }
        if(nb <5){
            for (int i = nb; i < 5; i++) {
                urls[i] = formatImageThumbUrl(cptEpl);
            }
        }
        return urls;
    }

    public static String[] getListMediasLot(String cptEpl,int nb){
        String[] urls;
        if (nb == 0 ) nb++;
        urls = new String[nb];
        urls[0] = formatImageThumbUrl(cptEpl);
        for (int i = 1; i < nb; i++) {
            urls[i] = formatImageThumUrl2(cptEpl, i+1);
        }
        return urls;
    }

    public static List<String> getListPlansEnsemble(String cptEpl, int nb){
        List<String> urls = new LinkedList<>();
        for (int i = 0; i < nb; i++) {
            urls.add(formatPlanArchiUrls(cptEpl,i+1));
        }
        return urls;
    }

    public static List<String> getListPlansLot(String cptEpl, int nb){
        List<String> urls = new LinkedList<>();
        for (int i = 0; i < nb; i++) {
            urls.add(formatPlanArchiUrls(cptEpl,i+1));
        }
        return urls;
    }

    public static String formatImageThumbPointContact(Integer idPc, String loc){
        return new StringBuilder("http://www.thomas-piron.eu/images/ensemble/800/").append(idPc.toString()).append("_").append(loc).append("/POINTCONTACT/").append(loc).append("_800_1.jpg").toString();
    }
    public static String formatImageThumbPointContact(Integer idPc, String loc,Integer num){
        return new StringBuilder("http://www.thomas-piron.eu/images/ensemble/800/").append(idPc.toString()).append("_").append(loc).append("/POINTCONTACT/").append(loc).append("_800_").append(num.toString()).append(".jpg").toString();
    }

    public static List <String> getListImageThumbPointContact(Integer idpc, String loc, Integer nb){
        List<String> urls = new LinkedList<>();
        for (Integer i = 0; i < nb; i++) {
            urls.add(formatImageThumbPointContact(idpc,loc,i+1));
        }
        if(nb < 5 ){
            for (int i = nb; i < 5; i++) {
                urls.add(formatImageThumbPointContact(idpc,loc,1));
            }
        }
        return urls;
    }


    public static List<String> formatMediaUrls(String cptEpl){

        String eplEncoded  =cptEpl.replaceAll(" ", "%20");
        List<String> urls = new ArrayList<>();
        urls.add("http://www.thomas-piron.eu/images/ensemble/rest/" + eplEncoded + "/MEDIA/" + eplEncoded + "_800_REF_1.jpg");
        urls.add("http://www.thomas-piron.eu/images/ensemble/800/"+eplEncoded+"/MEDIA/" +"/" + eplEncoded + "_800_2.jpg");
        urls.add("http://www.thomas-piron.eu/images/ensemble/800/"+eplEncoded+"/MEDIA/" +"/" + eplEncoded + "_800_3.jpg");
        urls.add("http://www.thomas-piron.eu/images/ensemble/800/"+eplEncoded+"/MEDIA/" +"/" + eplEncoded + "_800_4.jpg");
        urls.add("http://www.thomas-piron.eu/images/ensemble/800/"+eplEncoded+"/MEDIA/" +"/" + eplEncoded + "_800_5.jpg");
        urls.add("http://www.thomas-piron.eu/images/ensemble/800/"+eplEncoded+"/MEDIA/" +"/" + eplEncoded + "_800_6.jpg");
        return urls;
    }

    public static String formatPlanImplUrls(String cptEpl,Integer nb){
        String eplEncoded  =cptEpl.replaceAll(" ", "%20");
        String url = "";
        if (nb == 0) {
            url = "http://www.thomas-piron.eu/images/ensemble/1200/" + eplEncoded + "/PLANIMPL/" + eplEncoded + "_1200_ETAGE_IMPLAN_.jpg";
        }
        else{
            url = "http://www.thomas-piron.eu/images/ensemble/1200/" + eplEncoded + "/PLANIMPL/" + eplEncoded + "_1200_ETAGE_IMPLAN_.jpg";
        }
        return url;
    }

    public static String formatPlanArchiUrls(String cptEpl,Integer nb){
        String eplEncoded  =cptEpl.replaceAll(" ", "%20");
         return "http://www.thomas-piron.eu/images/ensemble/1200/" + eplEncoded + "/PLANARCHI/" + eplEncoded + "_1200_"+nb+".jpg";
    }

    public static String formatImageAPThumbUrl(String numero, String client) {
        return "http://www.inspiration-maison.com/ap/" + client + "-image-big.jpg";
    }


    public static List<String> getListMediasPlansEnsemble(String cptepl, Integer nbMedias, Integer nbPlans){
        List<String> urls = new LinkedList<>();
        urls.addAll(Arrays.asList(getListMediasEnsemble(cptepl, nbMedias)));
        urls.addAll(getListPlansEnsemble(cptepl, nbPlans));
        return urls;
    }

    public static  List<String> getListMediasPlansLot(String cptepl, Integer nbMedias, Integer nbPlans){
        List<String> urls = new LinkedList<>();
        urls.addAll(Arrays.asList(getListMediasLot(cptepl, nbMedias)));
        urls.addAll(getListPlansLot(cptepl, nbPlans));
        return urls;
    }

    public static String formatAPTitle (String num){
        if (Integer.parseInt(num) < 100){
            return new StringBuilder("Modèle ECO"+num).toString();
        }
        else{
            return new StringBuilder("Avant-projet "+num).toString();
        }
    }

    public static String formatItemsHouses(Maison maison,Context context){
        String toSell = "";
        Resources res = context.getResources();
        if (maison.getTerrainsPP() > 0){
            toSell += res.getQuantityString(R.plurals.land_pp,maison.getTerrainsPP(),maison.getTerrainsPP());
        }
        if (maison.getTerrainsPC() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.land_pc,maison.getTerrainsPC(),maison.getTerrainsPC());
        }
        if (maison.getMaisonsEC() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.house_cc,maison.getMaisonsEC(),maison.getMaisonsEC());
        }
        if (maison.getMaisonsC() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.house_c,maison.getMaisonsC(),maison.getMaisonsC());
        }

        return formatMultiLineText(toSell);
    }

    public static String formatItemsLands(Land item, Context context) {
        String toSell = "";
        Resources res = context.getResources();
        if (item.getNbTerrainsDispo() > 0){
            toSell += res.getQuantityString(R.plurals.terrain,item.getNbTerrainsDispo(),item.getNbTerrainsDispo());
        }
        return toSell;
    }

    public static String formatItemsApartments(Apartment item, Context context) {
        String toSell = "";
        Resources res = context.getResources();
        if (item.getNbApparts() > 0){
            toSell += res.getQuantityString(R.plurals.appart,item.getNbApparts(),item.getNbApparts());
        }
        if (item.getNbBureaux() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.bureau,item.getNbBureaux(),item.getNbBureaux());
        }
        if (item.getNbCommerces() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.commerce,item.getNbCommerces(),item.getNbCommerces());
        }
        if (item.getNbDuplex() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.duplex,item.getNbDuplex(),item.getNbDuplex());
        }
        if (item.getNbPenthouses() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.penthouse,item.getNbPenthouses(),item.getNbPenthouses());
        }
        if (item.getNbStudios() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.studios,item.getNbStudios(),item.getNbStudios());
        }
        if (item.getNbTriplex() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.triplex,item.getNbTriplex(),item.getNbTriplex());
        }
        if (item.getNbQuadriplex() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.quadriplex,item.getNbQuadriplex(),item.getNbQuadriplex());
        }

        return  formatMultiLineText(toSell);
    }

    public static String formatItemsApartmentsSingleLine(Apartment item, Context context) {
        String toSell = "";
        Resources res = context.getResources();
        if (item.getNbApparts() > 0){
            toSell += res.getQuantityString(R.plurals.appart,item.getNbApparts(),item.getNbApparts());
        }
        if (item.getNbBureaux() > 0){
            if (toSell != "") toSell += ", ";
            toSell += res.getQuantityString(R.plurals.bureau,item.getNbBureaux(),item.getNbBureaux());
        }
        if (item.getNbCommerces() > 0){
            if (toSell != "") toSell += ", ";
            toSell += res.getQuantityString(R.plurals.commerce,item.getNbCommerces(),item.getNbCommerces());
        }
        if (item.getNbDuplex() > 0){
            if (toSell != "") toSell += ", ";
            toSell += res.getQuantityString(R.plurals.duplex,item.getNbDuplex(),item.getNbDuplex());
        }
        if (item.getNbPenthouses() > 0){
            if (toSell != "") toSell += ", ";
            toSell += res.getQuantityString(R.plurals.penthouse,item.getNbPenthouses(),item.getNbPenthouses());
        }
        if (item.getNbStudios() > 0){
            if (toSell != "") toSell += ", ";
            toSell += res.getQuantityString(R.plurals.studios,item.getNbStudios(),item.getNbStudios());
        }
        if (item.getNbTriplex() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.triplex,item.getNbTriplex(),item.getNbTriplex());
        }
        if (item.getNbQuadriplex() > 0){
            if (toSell != "") toSell += ",";
            toSell += res.getQuantityString(R.plurals.quadriplex,item.getNbQuadriplex(),item.getNbQuadriplex());
        }
        return  toSell;
    }

    public static String formatDownloadAPPlan(String num) {
        if (Integer.parseInt(num) < 100){
            return new StringBuilder("http://www.inspiration-maison.com/pdf/ECO"+num+"-feuillet.pdf").toString();
        }
        else{
            return new StringBuilder("http://www.inspiration-maison.com/avant-projet/"+num+".pdf").toString();
        }
    }

    public static String getSharUrlExpo(Integer id, String loc, String type){
        String baseUrl = "http://www.thomas-piron.eu/fr/nos-activites/";
        StringBuilder builder = new StringBuilder(baseUrl);
        if(type.contains("maison")){
            builder.append("maison/maisons-expo/detail?expId=").append(id.toString()).append("&t=").append(type);
        }
        else{
            builder.append("appartement/appartements-temoin/detail?expId=").append(id.toString()).append("&t=").append(type);
        }
        return builder.toString();
    }

    public static String getShareUrlEnsemble(String ensecode, String cptepl,String socicode,String type) {
        String baseUrl = "http://www.thomas-piron.eu/fr/nos-activites/";
        String cat="";
        if(type.equals("house")){
            cat = "maison/achetez-une-maison-neuve/detail?PrId=";
        }
        if(type.equals("apart")){
            cat = "appartement/appartements-neufs-a-vendre/detail?PrId=";
        }
        if(type.equals("land")){
            cat = "maison/construire-sur-un-terrain-thomas-piron/detail?PrId=";
        }
            return new StringBuilder(baseUrl).append(cat)
                    .append(ensecode).append("&PrEpl=").append(cptepl.replaceAll(" ", "%20")).toString();

    }

    public static String getShareUrlAP(Integer param){
        return new StringBuilder("http://www.thomas-piron.eu/fr/nos-activites/maison/construction/inspiration/detail?ap=").append(param).toString();
    }

    public static String fromatDownloadLotPlan(String cptepl) {
        return new StringBuilder("http://www.thomas-piron.eu/images/ensemble/1200/").append(cptepl.replaceAll(" ", "%20"))
                .append("/PLANSPDF/").append(cptepl.replaceAll(" ", "%20")).append("_1200_1.pdf").toString();
    }

    public static String formatSubject(String subject) {
        return new StringBuilder("Téléchargement de la fiche: ").append(subject).toString();
    }

    public static String formatPebUrl(String pebClasseEnergetique) {
        return new StringBuilder("http://www.thomas-piron.eu/images/peb/peb_").append(pebClasseEnergetique.toLowerCase()).append(".gif").toString();
    }

    public static String formatTelNumber(String tel){
        return  tel.replace("(0)", "").replace("/", " ");
    }

    public static  String formatUrlImageNews(String image){
        return new StringBuilder("http://www.thomas-piron.eu/").append(image).toString();
    }

    public static String formatMultiLineText(String text){
        String[] parts = text.split(",");
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < parts.length-1; i++) {
            stringBuilder.append(parts[i]).append("\n");
        }
        stringBuilder.append(parts[parts.length-1]);
        return stringBuilder.toString();
    }

    public static List<String> getProvinceAll(){
        return Const.PROVINCES;
    }

    public static String getProvince(Integer pos){
        return Const.PROVINCES.get(pos);
    }

    public static String getProvincePrefered(Context c){
        return getProvince(PrefUtils.getProvinceFilter(c));
    }

    public static List<String> getTypeBienAll(){
        return Const.TYPES_BIEN;
    }

    public static String getTypeBien(Integer pos){
        return Const.TYPES_BIEN.get(pos);
    }

    public static String getTypeBienPrefered(Context c){
        return getTypeBien(PrefUtils.getDefaultScreen(c));
    }

    public static String formatImageAPThumbUrl(APModele apModele) {
        if( apModele.getNumero().equals("ECO"+apModele.getNumero_simplifie())){
            return new StringBuilder("http://www.thomas-piron.eu/images/inspiration/")
                    .append(apModele.getIdAPModele())
                    .append("/media/photo/")
                    .append(apModele.getNumero_simplifie())
                    .append("-01.jpg").toString();
        }
        else{
            return new StringBuilder("http://www.thomas-piron.eu/images/inspiration/")
                    .append(apModele.getIdAPModele())
                    .append("/media/photo/")
                    .append(apModele.getClient())
                    .append("-image-big.jpg").toString();
        }
    }
}
