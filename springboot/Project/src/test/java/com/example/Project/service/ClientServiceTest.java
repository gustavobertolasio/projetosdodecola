package com.example.Project.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyListOf;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Project.domain.entities.Client;
import com.example.Project.exception.DataNotFoundException;
import com.example.Project.repository.ClientRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * ClientServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private ClientRepository repositoryMock;

    @InjectMocks
    private ClientService service;

    private final Integer id = 1;
    private final String name = "Some string";
    private final String phone = "987654321";

    Client entity = Client.builder().id(id).name(name).phone(phone).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {

        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Client Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_findById() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Client model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Client deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<Client> list = new ArrayList<>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<Client> listR = service.listClient();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

    @Test
    public void should_createClient() {

        when(repositoryMock.save(entity)).thenReturn(entity);

        Client client = service.createClient(entity);

        verify(repositoryMock, times(1)).save(entity);
        assertNotNull("Criação de cliente tá zoada, tio", client);
    }

    @Test
    public void should_updateClient() {

        when(repositoryMock.save(entity)).thenReturn(entity);

        Client client = service.updateClient(entity);

        assertNotNull("Alteração de cliente tá zoada, tio", client);
    }

    @Test
    public void should_deleteClient() {
               // then
               expected.expect(DataNotFoundException.class);
               expected.expectMessage("Client Not found");
       
               // when
               service.deleteClient(entity);
    }

    @Test
    public void should_listDistinctClient() {
        List<String> oi = new ArrayList<>();
        oi.add(entity.getName());
        when(repositoryMock.listDistinct()).thenReturn(oi);
        
        List<String> cliento = service.listDistinct();

        assertNotNull(cliento);
    }

    @Test
    public void should_findClientsByPhone() {
        List<Client> clientes = new ArrayList<Client>();
        clientes.add(entity);
        when(repositoryMock.findByPhone(anyString())).thenReturn(clientes);

        List<Client> cliento = repositoryMock.findByPhone(anyString());

        verify(repositoryMock, times(1)).findByPhone(anyString());
        assertNotNull("Array não deve ser nulo", cliento);
    }

    @Test
    public void should_findClientsByPhoneOrderByName() {
        List<Client> clientes = new ArrayList<Client>();

        clientes.add(entity);
        when(repositoryMock.findByPhoneOrderByName(anyString())).thenReturn(clientes);

        List<Client> cliento = repositoryMock.findByPhoneOrderByName(anyString());

        verify(repositoryMock, times(1)).findByPhoneOrderByName(anyString());
        assertNotNull("Array não deve ser nulo", cliento);
    }

    @Test
    public void should_findByPhoneContainingOrderByName() {
        List<Client> clientes = new ArrayList<Client>();

        clientes.add(entity);
        when(repositoryMock.findByPhoneContainingOrderByName(anyString())).thenReturn(clientes);

        List<Client> cliento = repositoryMock.findByPhoneContainingOrderByName(anyString());

        verify(repositoryMock, times(1)).findByPhoneContainingOrderByName(anyString());
        assertNotNull("Array não deve ser nulo", cliento);
    }
}