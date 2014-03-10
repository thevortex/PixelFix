package Pixelfix.asm;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

import java.util.Map;

@TransformerExclusions(value={"Pixelfix.asm"})
public class PixelfixPlugin implements IFMLLoadingPlugin
{
    @Override
    public String[] getLibraryRequestClass()
    {
        return null;
    }

    @Override
    public String[] getASMTransformerClass()
    {
        return new String[] { "Pixelfix.asm.PixelfixClassTransformer" };
    }

    @Override
    public String getModContainerClass()
    {
        return "Pixelfix.asm.PixelfixModContainer";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
    }

    public Void call() throws Exception
    {
        return null;
    }
}
