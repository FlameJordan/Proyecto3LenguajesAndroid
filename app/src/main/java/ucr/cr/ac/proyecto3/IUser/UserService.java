package ucr.cr.ac.proyecto3.IUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import ucr.cr.ac.proyecto3.Request.CantonRequest;
import ucr.cr.ac.proyecto3.Request.DistritoRequest;
import ucr.cr.ac.proyecto3.Request.LoginRequest;

import ucr.cr.ac.proyecto3.Request.PacienteEditRequest;
import ucr.cr.ac.proyecto3.Request.PacienteRequest;
import ucr.cr.ac.proyecto3.model.AlergiaResponse;
import ucr.cr.ac.proyecto3.model.CantonResponse;
import ucr.cr.ac.proyecto3.model.CitasResponse;
import ucr.cr.ac.proyecto3.model.DistritoResponse;
import ucr.cr.ac.proyecto3.model.LoginResponse;
import ucr.cr.ac.proyecto3.model.PacienteActResponse;
import ucr.cr.ac.proyecto3.model.PacienteEditResponse;
import ucr.cr.ac.proyecto3.model.PacienteResponse;
import ucr.cr.ac.proyecto3.model.VacunaResponse;

public interface UserService {


    @POST("Pacientes/verificarpaciente")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("Canton/listarcantones")
    Call<CantonResponse> userCanton(@Body CantonRequest cantonRequest);

    @POST("Canton/listardistritos")
    Call<DistritoResponse> userDistrito(@Body DistritoRequest distritoRequest);

    @POST("Pacientes/insertarpaciente")
    Call<PacienteResponse> userPaciente(@Body PacienteRequest pacienteRequest);

    @GET("Citas/listarcitas")
    Call<CitasResponse> userCitas(@Query("cedula") String cedula);

    @GET("Alergias/listaralergias")
    Call<AlergiaResponse> userAlergias(@Query("cedula") String cedula);

    @GET("Pacientes/listarpaciente")
    Call<PacienteActResponse> userPacienteAct(@Query("cedula") String cedula);

    @PUT("Pacientes/editardatospersonales")
    Call<PacienteEditResponse> userPacienteEdit(@Body PacienteEditRequest pacienteActRequest);

    @GET("Vacunas/listarvacunas")
    Call<VacunaResponse> userVacuna(@Query("cedula") String cedula);

}
