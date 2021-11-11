package com.sextantlocator;

import com.sextantlocator.SextantLocatorPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class SextantLocatorTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(SextantLocatorPlugin.class);
		RuneLite.main(args);
	}
}
