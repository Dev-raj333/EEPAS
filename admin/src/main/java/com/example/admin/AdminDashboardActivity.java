package com.example.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class AdminDashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DashboardFragment()).commit();
            navigationView.setCheckedItem(R.id.dashboard);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.dashboard){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DashboardFragment()).commit();
        }else if(itemId == R.id.task){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TasksFragment()).commit();
        }else if(itemId == R.id.evaluation){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EvaluationFragment()).commit();
        }else if(itemId == R.id.department){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DepartmentFragment()).commit();
        }else if(itemId == R.id.designation){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DesignationFragment()).commit();
        }else if(itemId == R.id.employee){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EmployeeFragment()).commit();
        }else if(itemId == R.id.evaluator){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EvaluatorFragment()).commit();
        }else if(itemId == R.id.appraisal){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AppraisalFragment()).commit();
        } else if (itemId == R.id.admin){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserFragment()).commit();
        }else if(itemId == R.id.logout){
            showLogoutConformationDialog();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void showLogoutConformationDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                performLogout();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
    private void performLogout(){
        Toast.makeText(this, "Successfully Logout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}