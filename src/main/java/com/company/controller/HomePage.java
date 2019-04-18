package com.company.controller;

import com.company.domain.DeviceEntity;
import com.company.form.AddDeviceForm;
import com.company.repositories.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomePage {

    @Autowired
    private DevicesRepository devicesRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@ModelAttribute("newDevice") AddDeviceForm form, Model model) {
        model.addAttribute("devices", devicesRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addNewDevice(@Valid @ModelAttribute("newDevice") AddDeviceForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        // FIXME сделать проверку на существование устройства

        devicesRepository.save(new DeviceEntity(form.getDevID(), form.getName()));
        model.addAttribute("devices", devicesRepository.findAll());
        return "index";
    }
}
