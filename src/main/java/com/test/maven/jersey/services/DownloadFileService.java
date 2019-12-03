package com.test.maven.jersey.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import com.test.maven.jersey.exception.MissingFileException;
 
@Path("/download")
public class DownloadFileService 
{
    @GET
    @Path("/{fileName}")
    public Response downloadPdfFile(final @PathParam("fileName") String fileName) throws MissingFileException
    {
        final String fullFilePath = "C:/temp/" + fileName;
         
        File file = new File(fullFilePath);
         
        if(file.exists() == false){
            throw new MissingFileException(fileName + " does not existing on this server !!");
        }
         
        
        StreamingOutput fileStream =  new StreamingOutput()
        {
            @Override
            public void write(java.io.OutputStream output) throws IOException
            {
                try
                {
                    java.nio.file.Path path = Paths.get(fullFilePath);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } 
                catch (IOException e) 
                {
                    throw new IOException("Error while reading file :: '"+fileName+"' !!");
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename = '"+fileName)
                .build();
    }
}