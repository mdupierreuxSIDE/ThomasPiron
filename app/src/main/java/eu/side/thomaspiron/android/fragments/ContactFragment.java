package eu.side.thomaspiron.android.fragments;


import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Const;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.model.Contact;
import eu.side.thomaspiron.android.model.PointInteret;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 0;
    private static final String LOG_TAG = ContactFragment.class.getSimpleName();
    private TextView tvSubject;
    private EditText edPhone,edName,edFirstname,edComm,edLoc;
    private AutoCompleteTextView autoMail;
    private String mSubject;
    private FloatingActionButton fabSend;
    private Spinner spinSubject;
    private DownloadManager downloadManager;
    private long enqueue;

    private String mCptepl;
    private Boolean isInspiration = null;
    private String mDest;
    private String email, name,firstname,gsm;
    private List<String> sujets;
    private int idSujet;
    private List<PointInteret> mPointInterets;
    private Context mContext;
    private TextView tvMessage;
    private ApiClient apiClient;

    public ContactFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mSubject = getArguments().getString("CONTACT_SUBJECT", "");
            mCptepl = getArguments().getString("CPT_EPL","");
            mDest = getArguments().getString("DEST", "maximedupierreux@gmail.com");
            isInspiration = getArguments().getBoolean("INSPIRATION");

        }
        else{
            mDest = "maximedupierreux@gmail.com";
        }
        getActivity().registerReceiver(onComplete,
                new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(onComplete);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        //askForPhoneStatePerm();

        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        spinPays.setAdapter(adapter);*/
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getContext();
        spinSubject = (Spinner) view.findViewById(R.id.subjectSpinner);
        autoMail = (AutoCompleteTextView) view.findViewById(R.id.tvMail);
        edPhone = (EditText) view.findViewById(R.id.editGsm);
        edComm = (EditText) view.findViewById(R.id.editRem);
        edFirstname = (EditText) view.findViewById(R.id.editPrenom);
        edName = (EditText) view.findViewById(R.id.editNom);
        edLoc = (EditText) view.findViewById(R.id.editLoc);
        fabSend = (FloatingActionButton) view.findViewById(R.id.fabSend);
        fabSend.setOnClickListener(this);
        tvMessage = (TextView)view.findViewById(R.id.tvMessage);
        if (mSubject != null && !mSubject.equals("")) {
            tvSubject = (TextView) view.findViewById(R.id.tvSubject);
            tvSubject.setText(mSubject);
            spinSubject.setVisibility(View.GONE);
            edLoc.setVisibility(View.GONE);
        }
        else{
            loadSujets();
        }
        if(isInspiration != null && isInspiration){
            tvMessage.setText(R.string.contact_ispiration_info);
            tvMessage.setVisibility(View.VISIBLE);
        }
        fillEmailText();
        initEditText();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.action_maps);
        if (item != null) item.setVisible(false);
        item = menu.findItem(R.id.action_search);
        if(item != null) item.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initEditText() {
        SharedPreferences prefs = getActivity().getSharedPreferences("PREF_CONTACT",Context.MODE_PRIVATE);
        String email = prefs.getString("CONTACT_MAIL", "");
        String gsm = prefs.getString("CONTACT_GSM", "");
        String name = prefs.getString("CONTACT_NAME", "");
        String firstname = prefs.getString("CONTACT_FIRSTNAME","");
        if (!email.equals("")) {
            autoMail.setText(email);
        }
        edPhone.setText(gsm);
        edName.setText(name);
        edFirstname.setText(firstname);
    }

    private void loadSujets(){
        apiClient = new ApiClient();
        apiClient.getPointInteret(new Callback<List<PointInteret>>() {
            @Override
            public void onResponse(Call<List<PointInteret>> call, Response<List<PointInteret>> response) {
                sujets = new ArrayList<>();
                mPointInterets = response.body();
                for (PointInteret pointInteret : response.body()) {
                    sujets.add(pointInteret.getLibelleFr());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext,
                        android.R.layout.simple_dropdown_item_1line, sujets);
                spinSubject.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PointInteret>> call, Throwable throwable) {
                if(getView() != null) Snackbar.make(getView(), "Erreur lors du chargement des sujets, vérifiez votre connexion", Snackbar.LENGTH_SHORT).show();

            }
        });
    }


    public void fillEmailText(){
        Account[] accounts = AccountManager.get(getActivity()).getAccounts();
        List<String> emails = new ArrayList<>();
        for (Account account : accounts){
            emails.add(account.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,emails);
        autoMail.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        hideKeyboard();
        if(validForm()){sendContact(email, name,firstname,gsm,mCptepl, mSubject, mDest, edComm.getText().toString());}
    }

    public boolean validForm(){
        boolean valid = true;
        ////validation
        //email
        email = autoMail.getText().toString();
        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            autoMail.setError(getResources().getString(R.string.string_error_invalid_mail));
            valid = false;
        }

        //name
        name = edName.getText().toString();
        if (name.isEmpty()){
            edName.setError(getResources().getString(R.string.string_error_invalid_name));
            valid = false;
        }
        //firstname
        firstname = edFirstname.getText().toString();
        if (firstname.isEmpty()){
            edFirstname.setError(getResources().getString(R.string.string_error_invalid_firstname));
            valid = false;
        }
        //gsm
        gsm = edPhone.getText().toString();
        if (gsm.isEmpty()){
            edPhone.setError(getResources().getString(R.string.string_error_invalid_gsm));
            valid = false;
        }
        //sujet depuis la dropdown
        if (mSubject == null || mSubject.isEmpty() || spinSubject.getVisibility() == View.VISIBLE){
            mSubject = spinSubject.getSelectedItem().toString();
            idSujet = mPointInterets.get(spinSubject.getSelectedItemPosition()).getIdInteret();
            //mDest = mPointInterets.get(spinSubject.getSelectedItemPosition()).getEmail();
            if (idSujet < 5 ){ //home
                mDest = Const.getMailUN();
            }
            if ((idSujet > 4 && idSujet < 8) || (idSujet == 14)) { // bat
                mDest = Const.getMailMR();
            }
            if(idSujet == 13){ //reno
                mDest = Const.getMailReno();
            }
        }
        else{
            if(isInspiration){
                mDest = Const.getMailUN();
            }
            else {
                if (mCptepl.contains("1UNACIS")) { //reno
                    mDest = Const.getMailReno();
                }
                if (mCptepl.contains("09MR") || mCptepl.contains("18MR") || mCptepl.contains("1MRN") || mCptepl.contains("1UN") || mCptepl.contains("1MRW")) { //bat
                    mDest = Const.getMailMR();
                }

                if (mCptepl.contains("01UN")) { //home
                    mDest = Const.getMailUN();
                }
            }
        }


        return valid;
    }

    private void sendContact(String email, String name, String firstname, String gsm, final String cptepl, String sujet, String dest, String remarque) {
        Contact contact = new Contact();
        contact.setCptEpl(cptepl);
        contact.setEmail(email);
        contact.setGsm(gsm);
        contact.setLangue("F");
        contact.setNom(name);
        contact.setPrenom(firstname);
        ArrayList<String> recipients = new ArrayList<>();
        recipients.add(dest);
        contact.setRecipientToList(recipients);
        contact.setSujet(sujet);
        contact.setRemarque(remarque);

        SharedPreferences.Editor editor = getActivity().getSharedPreferences("PREF_CONTACT",Context.MODE_PRIVATE).edit();
        editor.putString("CONTACT_MAIL",email);
        editor.putString("CONTACT_GSM",gsm);
        editor.putString("CONTACT_LANGUE","F");
        editor.putString("CONTACT_NAME",name);
        editor.putString("CONTACT_FIRSTNAME",firstname);
        editor.commit();


        apiClient.postContact(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                downloadFile(cptepl);
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable throwable) {
               // if(getView() != null) Snackbar.make(getView(), "Erreur lors de l'envoi du formulaire", Snackbar.LENGTH_SHORT).show();

            }
        }, contact);
    }

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void downloadFile(String cptepl){
        if(getView() != null) Snackbar.make(getView(), "Merci d'avoir rempli le formulaire", Snackbar.LENGTH_LONG).show();
        if (isInspiration != null && !isInspiration && !mSubject.isEmpty()) { // il y a bien des plans a telecharger
            if(getActivity() != null) {
                downloadManager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                Uri downloadUri;
                if (isInspiration != true) {
                    downloadUri = Uri.parse(Utility.fromatDownloadLotPlan(cptepl));
                } else {
                    downloadUri = Uri.parse(Utility.formatDownloadAPPlan(cptepl));
                }

                DownloadManager.Request request = new DownloadManager.Request(downloadUri);
                enqueue = downloadManager.enqueue(request);
            }
        }
        if(isInspiration != null && isInspiration){
            tvMessage.setText(R.string.contact_ispiration_info_sent);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideKeyboard();
    }

    BroadcastReceiver onComplete=new BroadcastReceiver() {
        public void onReceive(Context ctxt, Intent intent) {
            long receivedID = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1L);
            DownloadManager mgr = (DownloadManager)
                    getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(receivedID);
            Cursor cur = mgr.query(query);
            int index = cur.getColumnIndex(DownloadManager.COLUMN_STATUS);
            int filenameIndex = cur.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME);
            if(cur.moveToFirst()) {
                if(cur.getInt(index) == DownloadManager.STATUS_SUCCESSFUL){
                    //Snackbar.make(getView(), cur.getString(filenameIndex), Snackbar.LENGTH_SHORT).show();
                    Intent testIntent = new Intent();
                    testIntent.setType("application/pdf");
                    testIntent.setAction(Intent.ACTION_VIEW);
                    Uri uri = Uri.fromFile(new File(cur.getString(filenameIndex)));
                    testIntent.setDataAndType(uri, "application/pdf");
                    if(testIntent.resolveActivity(getActivity().getPackageManager()) != null){
                        startActivity(testIntent);
                    }
                    else{
                        if (getView() != null) Snackbar.make(getView(), "Pas de lecteur PDF", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
            cur.close();
        }
    };

}
