package Pixelfix.asm;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import java.util.Arrays;

public class PixelfixModContainer extends DummyModContainer
{
    public PixelfixModContainer()
    {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId       = "Pixelfix";
        meta.name        = "Pixelmon Fix";
        meta.version     = "1.0.0.0";
        meta.authorList  = Arrays.asList("CCCP");
        meta.description = "Removes DRM from stupid mod makers\' stupid mod.";
        meta.url         = "http://svr.gov.ru/";
    }
    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        bus.register(this);
        return true;
    }

    @Subscribe
    public void init(FMLInitializationEvent event)
    {
    }
}
